package dev.members.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.members"})
@EntityScan(basePackages = {"dev.members"})
@EnableJpaRepositories(basePackages = "dev.members.infrastructure.model.repository")
public class MembersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembersServiceApplication.class, args);
    }


}
