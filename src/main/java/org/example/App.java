package org.example;


import org.example.config.AppConfig;
import org.springframework.boot.SpringApplication;

public class App
{
    public static void main(String[] args) {
        new SpringApplication(AppConfig.class).run(args);
    }
}
