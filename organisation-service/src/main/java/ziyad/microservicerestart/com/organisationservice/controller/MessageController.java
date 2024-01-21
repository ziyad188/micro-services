package ziyad.microservicerestart.com.organisationservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    //this is to read the value from application.properties file
    @Value("${spring.boot.message}")
    private String message;
    @GetMapping("/user/message")
    public String message(){
        return message;
    }
}
