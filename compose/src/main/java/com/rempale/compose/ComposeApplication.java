package com.rempale.compose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComposeApplication.class, args);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner init(JdbcTemplate jdbc) {
        return args -> jdbc.execute(
                "CREATE TABLE IF NOT EXISTS kv (key TEXT PRIMARY KEY, value TEXT)"
        );
    }
}
