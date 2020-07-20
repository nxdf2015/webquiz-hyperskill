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
//    public QuizzList(){
//        questions=List.of(
//                Question.of(1,
//                "The java logo",
//                "What is depicted on the Java logo?",
//                2,"Robot","Tea leaf","Cup of coffee","Bug"),
//                Question.of(2,
//                        "The Ultimate Question",
//                        "What is the answer to the Ultimate Question of Life, the Universe and Everything?",
//                        2,"Everything goes right","42","2+2=4","11011100")
//        );
//    }

    public List<Question> getAll() {
        return questions;
    }
//    public  String questionsToJson() throws IOException {
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        JsonFactory factory = new JsonFactory();
//        JsonGenerator jsonGenerator = factory.createGenerator(stream, JsonEncoding.UTF8);
//
//
//
//        jsonGenerator.writeStartArray();
//
//        questions.stream()
//                .forEach(question -> {
//                    try {
//                        jsonGenerator.writeStartObject();
//                            jsonGenerator.writeNumberField("id",question.getId());
//                            jsonGenerator.writeStringField("title",question.getTitle());
//                            jsonGenerator.writeStringField("text",question.getText());
//                            jsonGenerator.writeFieldName("options");
//                                jsonGenerator.writeStartArray();
//                                for(String option : question.getOptions()){
//                                    jsonGenerator.writeString(option);
//                                }
//                                jsonGenerator.writeEndArray();
//                        jsonGenerator.writeEndObject();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
//        jsonGenerator.writeEndArray();
//
//
//        return new String(stream.toByteArray(),"UTF-8");
//
//    }

//    public String questionToJson(int id) throws IOException {
//        Question question = getById(id);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        JsonFactory factory = new JsonFactory();
//        JsonGenerator generator = factory.createGenerator(stream,JsonEncoding.UTF8);
//        generator.writeStartObject();
//        generator.writeNumberField("id",question.getId());
//        generator.writeStringField("title",question.getTitle());
//        generator.writeStringField("text",question.getText());
//        generator.writeFieldName("options");
//        generator.writeStartArray();
//        for(String option: question.getOptions()){
//            generator.writeString(option);
//        }
//        generator.writeEndArray();
//        generator.writeEndObject();
//
//        return new String(stream.toByteArray(),"UTF-8");
//
//    }
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
