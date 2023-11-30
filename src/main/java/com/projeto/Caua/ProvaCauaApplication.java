package com.projeto.Caua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.projeto.Caua.model")
@ComponentScan(basePackages = "com.projeto.Caua")
@EnableJpaRepositories(basePackages = "com.projeto.Caua.repository")
@EnableTransactionManagement

public class ProvaCauaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvaCauaApplication.class, args);
    }
}
