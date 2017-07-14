package cleartax.survey.com.surveytap.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cleartax.survey.com.surveytap.R;
import cleartax.survey.com.surveytap.models.AnswerItem;
import cleartax.survey.com.surveytap.models.QuestionItem;

/**
 * Created by ankit.ag on 14/07/16.
 */
public class VendorResultsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<AnswerItem> answerItems;
    private ArrayList<QuestionItem> questionsItems;


    public VendorResultsAdapter(Context context, ArrayList<QuestionItem> questionItems, ArrayList<AnswerItem> answerItems){
        this.context = context;
        this.questionsItems = questionItems;
        this.answerItems = answerItems;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.setData(questionsItems.get(position), answerItems.get(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= inflater.inflate(R.layout.vendor_result_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return questionsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        TextView firstOption;
        TextView secondOption;
        TextView thirdOOption;
        TextView fourthOption;
        TextView totalVotesFirstOption;
        TextView totalVotesSecondOption;
        TextView totalVotesThirdOption;
        TextView totalVotesFourthOption;

        public ViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.question);
            firstOption = (TextView) itemView.findViewById(R.id.first_option);
            totalVotesFirstOption = (TextView) itemView.findViewById(R.id.total_votes_first_option);
            secondOption = (TextView) itemView.findViewById(R.id.second_option);
            totalVotesSecondOption = (TextView) itemView.findViewById(R.id.total_votes_second_option);
            thirdOOption = (TextView) itemView.findViewById(R.id.third_option);
            totalVotesThirdOption = (TextView) itemView.findViewById(R.id.total_votes_third_option);
            fourthOption = (TextView) itemView.findViewById(R.id.fourth_option);
            totalVotesFourthOption = (TextView) itemView.findViewById(R.id.total_votes_fourth_option);
        }

        public void setData(QuestionItem questionItem, AnswerItem answerItem){
            question.setText(answerItem.getQuestionStatement());
            firstOption.setText(questionItem.getOptionFirst());
            secondOption.setText(questionItem.getOptionSecond());
            thirdOOption.setText(questionItem.getOptionThird());
            fourthOption.setText(questionItem.getOptionFourth());
            totalVotesFirstOption.setText("" + answerItem.getFirstOptionCount());
            totalVotesSecondOption.setText(""+ answerItem.getSecondOptionCount());
            totalVotesThirdOption.setText("" + answerItem.getThirdOptionCount());
            totalVotesFourthOption.setText("" + answerItem.getFourthOptionCount());
        }
    }
}
