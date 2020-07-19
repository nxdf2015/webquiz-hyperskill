package engine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class QuizzController {

    @GetMapping("/api/quiz")
    public String getQuizz(){
        return "{\"title\":\"The Java Logo\",\"text\":\"What is depicted on the Java logo?\",\"options\":[\"Robot\",\"Tea leaf\",\"Cup of coffee\",\"Bug\"]}";

    }

    @PostMapping("/api/quiz")
    public String solveQuizz(@RequestBody String body){
        int i = Integer.parseInt(body.split("=")[1]);
        if (i == 2){
            return "{\"success\":true,\"feedback\":\"Congratulations, you're right!\"}\n";
        }
        else {
            return "{\"success\":false,\"feedback\":\"Wrong answer! Please, try again.\"}\n";
        }
    }
}