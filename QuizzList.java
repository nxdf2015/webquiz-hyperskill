package engine;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class QuizzList {
    private List<Question> questions;

    public QuizzList(){
        this.questions = new ArrayList<>();
    }


    public List<Question> getAll() {
        return questions;
    }

    public Question getById(int id){
        return questions.stream().filter( q -> q.getId() == id)
                .collect(Collectors.toList()).get(0);
    }


    public void add(Question question) {
        questions.add(question);
    }

    public boolean isValidQuestion(int id) {
        return id < questions.size();
    }
}
