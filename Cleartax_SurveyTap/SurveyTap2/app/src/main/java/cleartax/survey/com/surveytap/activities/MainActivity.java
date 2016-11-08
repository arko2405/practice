package cleartax.survey.com.surveytap.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cleartax.survey.com.surveytap.R;
import cleartax.survey.com.surveytap.adapters.CustomerQuestionsAdapter;
import cleartax.survey.com.surveytap.common.Database;
import cleartax.survey.com.surveytap.models.AnswerItem;
import cleartax.survey.com.surveytap.models.QuestionItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CustomerQuestionsAdapter adapter;
    private ArrayList<QuestionItem> questionItems;
    private ArrayList<AnswerItem> answerItems;
    private RecyclerView questionsListView;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(this);
        questionItems = new ArrayList<>();
        answerItems = new ArrayList<>();
        questionsListView = (RecyclerView) findViewById(R.id.questions_list);
        questionsListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerQuestionsAdapter(this, questionItems, answerItems);
        questionsListView.setAdapter(adapter);
        inflateQuestionsList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.login:
                Intent loginIntent = new Intent(this, LoginActivity.class);
                startActivity(loginIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.submit_btn:
                Toast.makeText(this, "Submitting your opinion...", Toast.LENGTH_SHORT).show();
                updateVotesCount();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();               // to exit the app
    }

    //Inflate the questions list in the user mode
    private void inflateQuestionsList(){
        Database db = Database.getDatabaseInstance(this);
        ArrayList<QuestionItem> questionsList = db.getQuestionsList();
        for(QuestionItem questionItem :questionsList){
            questionItems.add(questionItem);
            answerItems.add(new AnswerItem(questionItem.getQuestionStatement()));
        }
        if(questionsList.size()>0)
            submitBtn.setEnabled(true);
        adapter.notifyDataSetChanged();
    }

    //Update the votes count in the database whenever the user submits the survey.
    private void updateVotesCount(){
        answerItems = adapter.getAnswers();
        if(answerItems.size()>0){
            for(AnswerItem answerItem: answerItems){
                AnswerItem answerItemfromDB = Database.getDatabaseInstance(this).getAnswerItem(answerItem.getQuestionStatement());
                if (answerItem.getFirstOptionCount() != 0) {
                    answerItemfromDB.setFirstOptionCount(answerItemfromDB.getFirstOptionCount()+1);
                }
                else if (answerItem.getSecondOptionCount() != 0) {
                    answerItemfromDB.setSecondOptionCount(answerItemfromDB.getSecondOptionCount()+1);
                }
                else if (answerItem.getThirdOptionCount() != 0) {
                    answerItemfromDB.setThirdOptionCount(answerItemfromDB.getThirdOptionCount()+1);
                }
                else
                    answerItemfromDB.setFourthOptionCount(answerItemfromDB.getFourthOptionCount()+1);

                //Update the answers table!
                Database.getDatabaseInstance(this).updateAnswerItem(answerItemfromDB);
            }
        }
    }
}
