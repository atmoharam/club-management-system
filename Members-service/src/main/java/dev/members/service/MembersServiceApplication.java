package dev.members.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {})
@EntityScan(basePackageClasses = {})
@SpringBootApplication(scanBasePackages = "dev.members.service")
public class MembersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembersServiceApplication.class, args);
    }

}
