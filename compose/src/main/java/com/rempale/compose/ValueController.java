package com.rempale.compose;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValueController {

    private final JdbcTemplate jdbc;

    public ValueController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostMapping("/write")
    public String write(@RequestParam String key, @RequestParam String value) {
        jdbc.update(
                "INSERT INTO kv(key, value) VALUES (?, ?)", key, value
        );
        return "OK";
    }

    @GetMapping("/read")
    public String read(@RequestParam String key) {
        var rows = jdbc.queryForList(
                "SELECT value FROM kv WHERE key = ?", String.class, key
        );
        return rows.isEmpty() ? "(nil)" : rows.getFirst();
    }
}