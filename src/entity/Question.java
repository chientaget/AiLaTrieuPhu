package entity;

import java.io.Serializable;

public class Question implements Serializable {

    
    private Integer id;
    private String topic;
    private String ques;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answerCorrect;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String topic, String ques, String answer1, String answer2, String answer3, String answerCorrect) {
        this.id = id;
        this.topic = topic;
        this.ques = ques;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answerCorrect = answerCorrect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", topic=" + topic + ", ques=" + ques + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answerCorrect=" + answerCorrect + '}';
    }

    
    
}
