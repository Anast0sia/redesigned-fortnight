package com.example.demo.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class ProductRepository {
    private final String sql = read("query.sql");
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> find(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return namedParameterJdbcTemplate.queryForList(sql, map, String.class);
    }
}