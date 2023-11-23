package br.com.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class,args);
    }

    @RequestMapping("/")
    public String home() {
        return "API - FollowCare";
    }
}