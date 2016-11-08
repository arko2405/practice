package cleartax.survey.com.surveytap.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cleartax.survey.com.surveytap.R;
import cleartax.survey.com.surveytap.models.AnswerItem;
import cleartax.survey.com.surveytap.models.QuestionItem;

/**
 * Created by ankit.ag on 13/07/16.
 */
public class CustomerQuestionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<QuestionItem> questionsItems;
    private ArrayList<AnswerItem> answerItems;

    public CustomerQuestionsAdapter(Context context, ArrayList<QuestionItem> questionItems, ArrayList<AnswerItem> answerItems){
        this.context = context;
        this.questionsItems = questionItems;
        this.answerItems = answerItems;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        QuestionItem questionItem = questionsItems.get(position);
        QuestionViewHolder viewHolder = (QuestionViewHolder) holder;
        viewHolder.setData(questionItem, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= inflater.inflate(R.layout.question_item, parent, false);
        return new QuestionViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return questionsItems.size();
    }

    public ArrayList<AnswerItem> getAnswers() {
        return answerItems;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        TextView questionStatement;
        RadioGroup questionItem;
        RadioButton firstOption;
        RadioButton secondOption;
        RadioButton thirdOption;
        RadioButton fourthOption;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            questionStatement = (TextView) itemView.findViewById(R.id.question);
            questionItem = (RadioGroup) itemView.findViewById(R.id.options_list);
            firstOption = (RadioButton) itemView.findViewById(R.id.first_option);
            secondOption = (RadioButton) itemView.findViewById(R.id.second_option);
            thirdOption = (RadioButton) itemView.findViewById(R.id.third_option);
            fourthOption = (RadioButton) itemView.findViewById(R.id.fourth_option);
        }

        public void setData(QuestionItem item, final int position){
            questionStatement.setText(item.getQuestionStatement());
            firstOption.setText(item.getOptionFirst());
            secondOption.setText(item.getOptionSecond());
            thirdOption.setText(item.getOptionThird());
            fourthOption.setText(item.getOptionFourth());
            questionItem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    updateItem(group, position);
                }
            });
            updateItem(questionItem, position);
        }

        public void updateItem(RadioGroup group, int position) {
            AnswerItem answerItem = answerItems.get(position);
            int id = group.getCheckedRadioButtonId();
            if (id == R.id.first_option) {
                answerItem.setFirstOptionCount(1);
                answerItem.setSecondOptionCount(0);
                answerItem.setThirdOptionCount(0);
                answerItem.setFourthOptionCount(0);
            }
            else if (id == R.id.second_option) {
                answerItem.setFirstOptionCount(0);
                answerItem.setSecondOptionCount(1);
                answerItem.setThirdOptionCount(0);
                answerItem.setFourthOptionCount(0);
            }
            else if (id == R.id.third_option) {
                answerItem.setFirstOptionCount(0);
                answerItem.setSecondOptionCount(0);
                answerItem.setThirdOptionCount(1);
                answerItem.setFourthOptionCount(0);
            }
            else{
                answerItem.setFirstOptionCount(0);
                answerItem.setSecondOptionCount(0);
                answerItem.setThirdOptionCount(0);
                answerItem.setFourthOptionCount(1);
            }
            answerItems.set(position, answerItem);
        }
    }


}
