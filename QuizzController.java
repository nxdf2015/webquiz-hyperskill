package engine;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController()
public class QuizzController {

    @Autowired
    private QuizzList quizzList;



    @GetMapping(path = "/api/quizzes" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> getAll() throws IOException {

        return quizzList.getAll();
    }

    @GetMapping(value = "/api/quizzes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Question getById(@PathVariable int id) throws IOException {
        if (quizzList.isValidQuestion(id)){
            return quizzList.getById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "/api/quizzes"  , produces = MediaType.APPLICATION_JSON_VALUE)
    public  Question  create(@RequestBody  String data  ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

       Question question = mapper.readValue(data,Question.class);

       question.generateId();
       question.setAnswer( mapper.readTree(data).get("answer").intValue());
       quizzList.add(question);

        return  question;
    }

    @PostMapping("api/quizzes/{id}/solve")
    public String solve(@PathVariable int id, @RequestBody  String body){
        if (!quizzList.isValidQuestion(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        int idResponse = Integer.parseInt(body.split("=")[1]);

        Question question = quizzList.getById(id);
        System.out.println(question);
        if(question.isValidAnswer(idResponse)){
            return "{\"success\":true,\"feedback\":\"Congratulations, you're right!\"}\n";
        }
        else {
            return "{\"success\":false,\"feedback\":\"Wrong answer! Please, try again.\"}\n";
        }
    }


}