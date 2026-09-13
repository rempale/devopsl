package com.rempale.volumedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VolumeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolumeDemoApplication.class, args);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner init(JdbcTemplate jdbc) {
        return args -> jdbc.execute(
                "CREATE TABLE IF NOT EXISTS kv (key TEXT PRIMARY KEY, value TEXT)"
        );
    }
}