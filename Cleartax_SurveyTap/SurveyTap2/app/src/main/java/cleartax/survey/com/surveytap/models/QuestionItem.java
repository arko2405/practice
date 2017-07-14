package cleartax.survey.com.surveytap.models;

/**
 * Created by ankit.ag on 13/07/16.
 */
public class QuestionItem {
    public String questionID ;
    public String questionStatement;
    public String optionFirst;
    public String optionSecond;
    public String optionThird;
    public String optionFourth;

    public QuestionItem(){

    }
    public QuestionItem(String questionStatement, String optionFirst, String optionSecond, String optionThird, String optionFourth) {
        this.questionStatement = questionStatement;
        this.optionFirst = optionFirst;
        this.optionSecond = optionSecond;
        this.optionThird = optionThird;
        this.optionFourth = optionFourth;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public String getOptionFirst() {
        return optionFirst;
    }

    public String getOptionSecond() {
        return optionSecond;
    }

    public String getOptionThird() {
        return optionThird;
    }

    public String getOptionFourth() {
        return optionFourth;
    }
}

