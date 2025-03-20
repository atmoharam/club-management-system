package dev.sport.service.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"dev.sport.service"})
@EntityScan(basePackages = {"dev.sport.service"})
@EnableJpaRepositories(basePackages = "dev.sport.service.infrastructure.model.repository")
public class SportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportServiceApplication.class, args);
    }

}
