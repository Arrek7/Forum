package com.comarch.szkolenia.forum;

import com.comarch.szkolenia.forum.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);

    }
}
