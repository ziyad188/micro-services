package ziyad.microservicerestart.com.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {
    //this is to read the value from application.properties file
    @Value("${spring.boot.message}")
    private String message;
    @GetMapping("message")
    public String message(){
        return message;
    }
}
