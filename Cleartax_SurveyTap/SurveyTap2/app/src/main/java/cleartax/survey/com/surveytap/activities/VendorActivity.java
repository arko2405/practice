package cleartax.survey.com.surveytap.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import cleartax.survey.com.surveytap.R;
import cleartax.survey.com.surveytap.adapters.VendorResultsAdapter;
import cleartax.survey.com.surveytap.common.Database;
import cleartax.survey.com.surveytap.models.AnswerItem;
import cleartax.survey.com.surveytap.models.QuestionItem;

/**
 * Created by ankit.ag on 13/07/16.
 */
public class VendorActivity extends AppCompatActivity {

    private VendorResultsAdapter adapter;
    private RecyclerView answersListView;
    private ArrayList<QuestionItem> questionItems;
    private ArrayList<AnswerItem> answerItems;
    private TextView noQuestions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        questionItems = new ArrayList<>();
        answerItems = new ArrayList<>();
        answersListView = (RecyclerView) findViewById(R.id.answers_list);
        answersListView.setLayoutManager(new LinearLayoutManager(this));
        Database db = Database.getDatabaseInstance(this);
        questionItems = db.getQuestionsList();
        answerItems = db.getAnswersList();
        adapter = new VendorResultsAdapter(this, questionItems, answerItems);
        answersListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_vendor, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                //add question to database
                Intent intent = new Intent(VendorActivity.this, QuestionActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        openDialog();

    }

    // Show the vendor a dialog to log out from the vendor mode.
    public void openDialog(){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to log out?");

        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(VendorActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        alertDialogBuilder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
