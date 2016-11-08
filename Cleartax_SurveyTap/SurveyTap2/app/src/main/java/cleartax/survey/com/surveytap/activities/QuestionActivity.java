package cleartax.survey.com.surveytap.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cleartax.survey.com.surveytap.R;
import cleartax.survey.com.surveytap.common.Database;
import cleartax.survey.com.surveytap.models.AnswerItem;
import cleartax.survey.com.surveytap.models.QuestionItem;

/**
 * Created by ankit.ag on 14/07/16.
 */
public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText questionStatement;
    private EditText firstOption;
    private EditText secondOption;
    private EditText thirdOption;
    private EditText fourthOption;
    private Button submitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        questionStatement = (EditText) findViewById(R.id.question);
        firstOption = (EditText) findViewById(R.id.first_option);
        secondOption = (EditText) findViewById(R.id.second_option);
        thirdOption = (EditText) findViewById(R.id.third_option);
        fourthOption = (EditText) findViewById(R.id.fourth_option);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.submit_button:                                //Add the question to the database
                QuestionItem questionItem = new QuestionItem();
                questionItem.questionStatement = questionStatement.getText().toString();
                questionItem.optionFirst = firstOption.getText().toString();
                questionItem.optionSecond = secondOption.getText().toString();
                questionItem.optionThird = thirdOption.getText().toString();
                questionItem.optionFourth = fourthOption.getText().toString();
                Database.getDatabaseInstance(this).insertQuestion(questionItem);

                //Add the corresponding entry in Answers table as well
                AnswerItem answerItem = new AnswerItem();
                answerItem.questionStatement = questionStatement.getText().toString();
                Database.getDatabaseInstance(this).insertAnswer(answerItem);

                Intent intent = new Intent(this, VendorActivity.class);         //once question is added in database, go to VendorActivity
                startActivity(intent);
        }
    }
}
