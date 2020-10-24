package com.vipul.project.iplproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.vipul.project.iplproject.repositories")
public class IplprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(IplprojectApplication.class, args);
    }
}
