package com.mycommerce.ecommerce;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Load .env
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Set environment properties so Spring Boot can use the

        // Just to verify
        System.out.println("DB_URL=" + dotenv.get("DB_URL"));
        SpringApplication.run(Application.class, args);
    }
}
