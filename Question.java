package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


public class Question {

    public static  int count = 0;

    private  int id;
    private String title;
    private String text;
    private List<String> options;

    @JsonIgnore
    private int answer;

    public Question() {
    }

    public Question( String title, String text, String[] options, int answer) {

        this.title = title;
        this.text = text;
        this.options = Arrays.asList(options);
        this.answer = answer;
    }

    public static Question of (    String title, String text, int answer, String ... options) {

        return new Question( title,text,options,answer);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id =id ;
    }

    public boolean isValidAnswer(int answer){
        return answer == this.answer;
    }

    public void generateId() {
        id = count;
        count++;

    }
}


