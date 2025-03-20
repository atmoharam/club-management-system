package dev.security.gate.service.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"dev.security"})
@EntityScan(basePackages = {"dev.security"})
@EnableJpaRepositories(basePackages = "dev.security.gate.service.infrastructure.model.repository")
public class SecurityGateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityGateServiceApplication.class, args);
    }

}
