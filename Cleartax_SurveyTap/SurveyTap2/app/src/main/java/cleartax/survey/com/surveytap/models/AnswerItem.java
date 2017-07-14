package cleartax.survey.com.surveytap.models;

/**
 * Created by ankit.ag on 14/07/16.
 */
public class AnswerItem {
    public String questionStatement;
    public int firstOptionCount;
    public int secondOptionCount;
    public int thirdOptionCount;
    public int fourthOptionCount;

    public AnswerItem(){

    }

    public AnswerItem(String questionStatement, int firstOptionCount, int secondOptionCount, int thirdOptionCount, int fourthOptionCount) {
        this.questionStatement = questionStatement;
        this.firstOptionCount = firstOptionCount;
        this.secondOptionCount = secondOptionCount;
        this.thirdOptionCount = thirdOptionCount;
        this.fourthOptionCount = fourthOptionCount;
    }

    public AnswerItem(String questionStatement){
        this.questionStatement = questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public void setFirstOptionCount(int firstOptionCount) {
        this.firstOptionCount = firstOptionCount;
    }

    public void setSecondOptionCount(int secondOptionCount) {
        this.secondOptionCount = secondOptionCount;
    }

    public void setThirdOptionCount(int thirdOptionCount) {
        this.thirdOptionCount = thirdOptionCount;
    }

    public void setFourthOptionCount(int fourthOptionCount) {
        this.fourthOptionCount = fourthOptionCount;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public int getFirstOptionCount() {
        return firstOptionCount;
    }

    public int getSecondOptionCount() {
        return secondOptionCount;
    }

    public int getThirdOptionCount() {
        return thirdOptionCount;
    }

    public int getFourthOptionCount() {
        return fourthOptionCount;
    }
}
