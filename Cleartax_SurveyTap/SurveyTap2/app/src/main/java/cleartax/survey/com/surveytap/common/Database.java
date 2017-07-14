package cleartax.survey.com.surveytap.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cleartax.survey.com.surveytap.models.AnswerItem;
import cleartax.survey.com.surveytap.models.QuestionItem;

/**
 * Created by ankit.ag on 14/07/16.
 */
public class Database extends SQLiteOpenHelper {
    public static String DB_NAME = "surveytap.db";
    private SQLiteDatabase mydb = null;
    private static final int DB_VERSION = 1;
    private static Database ldb;

    private final String QUESTIONS_TABLE ="questions_table";
    private final String ANSWERS_TABLE ="answers_table";

    //Question Table columns
    private String QUESTION_ID = "question_id";
    private String QUESTION_STATEMENT="question_statement";
    private String FIRST_OPTION="first_option";
    private String SECOND_OPTION="second_option";
    private String THIRD_OPTION="third_option";
    private String FOURTH_OPTION="fourth_option";

    //Answer Table Columns
    private String FIRST_OPTION_COUNT="first_option_count";
    private String SECOND_OPTION_COUNT="second_option_count";
    private String THIRD_OPTION_COUNT="third_option_count";
    private String FOURTH_OPTION_COUNT="fourth_option_count";

    public static Database getDatabaseInstance(Context context){
        if (ldb == null) {
            synchronized (context) {
                if (ldb == null) {
                    ldb = new Database(context);
                }
            }
        }
        return ldb;
    }

    private Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mydb = getWritableDatabase();
        mydb.setVersion(DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String questionsTable = "create table " + QUESTIONS_TABLE + " ( " + QUESTION_ID
                + " TEXT PRIMARY KEY," + QUESTION_STATEMENT + " TEXT(250)," +
                FIRST_OPTION + " TEXT," + SECOND_OPTION + " TEXT," +
                THIRD_OPTION + " TEXT," + FOURTH_OPTION + " TEXT"
                 + ")";

        String answersTable = "create table " + ANSWERS_TABLE + " ( " + QUESTION_STATEMENT + " TEXT PRIMARY KEY," +
                FIRST_OPTION_COUNT + " int," + SECOND_OPTION_COUNT + " int," +
                THIRD_OPTION_COUNT + " int," + FOURTH_OPTION_COUNT + " int"
                + ")";

        db.beginTransaction();
        db.execSQL(questionsTable);
        db.execSQL(answersTable);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertQuestion(final QuestionItem question){
        ContentValues values = new ContentValues();
        values.put(QUESTION_ID, question.questionID);
        values.put(QUESTION_STATEMENT, question.questionStatement);
        values.put(FIRST_OPTION, question.optionFirst);
        values.put(SECOND_OPTION, question.optionSecond);
        values.put(THIRD_OPTION, question.optionThird);
        values.put(FOURTH_OPTION, question.optionFourth);
        return mydb.insert(QUESTIONS_TABLE, null, values);
    }

    public ArrayList<QuestionItem> getQuestionsList() {

        Cursor c = mydb.query(QUESTIONS_TABLE, null, null, null, null, null, null);
        ArrayList<QuestionItem> questions = new ArrayList<QuestionItem>();
        QuestionItem temp;
        while (c.moveToNext()) {
            temp = new QuestionItem();
            try {
                temp.questionID = c.getString(c.getColumnIndex(QUESTION_ID));
                temp.questionStatement = c.getString((c.getColumnIndex(QUESTION_STATEMENT)));
                temp.optionFirst = c.getString(c.getColumnIndex(FIRST_OPTION));
                temp.optionSecond = c.getString(c.getColumnIndex(SECOND_OPTION));
                temp.optionThird = c.getString(c.getColumnIndex(THIRD_OPTION));
                temp.optionFourth = c.getString(c.getColumnIndex(FOURTH_OPTION));
                questions.add(temp);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        c.close();
        return questions;
    }

    public long insertAnswer(final AnswerItem answer){
        ContentValues values = new ContentValues();
        values.put(QUESTION_STATEMENT, answer.questionStatement);
        values.put(FIRST_OPTION_COUNT, answer.firstOptionCount);
        values.put(SECOND_OPTION_COUNT, answer.secondOptionCount);
        values.put(THIRD_OPTION_COUNT, answer.thirdOptionCount);
        values.put(FOURTH_OPTION_COUNT, answer.fourthOptionCount);
        return mydb.insert(ANSWERS_TABLE, null, values);
    }

    public ArrayList<AnswerItem> getAnswersList() {

        Cursor c = mydb.query(ANSWERS_TABLE, null, null, null, null, null, null);
        ArrayList<AnswerItem> answers = new ArrayList<AnswerItem>();
        AnswerItem temp;
        while (c.moveToNext()) {
            temp = new AnswerItem();
            try {
                temp.questionStatement = c.getString((c.getColumnIndex(QUESTION_STATEMENT)));
                temp.firstOptionCount = c.getInt(c.getColumnIndex(FIRST_OPTION_COUNT));
                temp.secondOptionCount = c.getInt(c.getColumnIndex(SECOND_OPTION_COUNT));
                temp.thirdOptionCount = c.getInt(c.getColumnIndex(THIRD_OPTION_COUNT));
                temp.fourthOptionCount = c.getInt(c.getColumnIndex(FOURTH_OPTION_COUNT));
                answers.add(temp);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        c.close();
        return answers;
    }

    public AnswerItem getAnswerItem(String questionStatement) {
        AnswerItem temp = null;
        String condition = QUESTION_STATEMENT + " ='" + questionStatement + "'";
        Cursor c = mydb.query(ANSWERS_TABLE, null, condition, null, null, null, null);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                try {
                    temp = new AnswerItem();
                    temp.questionStatement = c.getString((c.getColumnIndex(QUESTION_STATEMENT)));
                    temp.firstOptionCount = c.getInt(c.getColumnIndex(FIRST_OPTION_COUNT));
                    temp.secondOptionCount = c.getInt(c.getColumnIndex(SECOND_OPTION_COUNT));
                    temp.thirdOptionCount = c.getInt(c.getColumnIndex(THIRD_OPTION_COUNT));
                    temp.fourthOptionCount = c.getInt(c.getColumnIndex(FOURTH_OPTION_COUNT));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c.close();
        }
        return temp;
    }

    public int updateAnswerItem(AnswerItem answerItem) {
        String condition = QUESTION_STATEMENT + " ='" + answerItem.questionStatement + "'";
        ContentValues values = new ContentValues();
        values.put(FIRST_OPTION_COUNT, answerItem.getFirstOptionCount());
        values.put(SECOND_OPTION_COUNT, answerItem.getSecondOptionCount());
        values.put(THIRD_OPTION_COUNT, answerItem.getThirdOptionCount());
        values.put(FOURTH_OPTION_COUNT, answerItem.getFourthOptionCount());
        return mydb.update(ANSWERS_TABLE, values, condition, null);
    }

}
