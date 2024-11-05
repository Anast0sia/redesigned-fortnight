package com.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class ProductRepository {
    private final String sql = read("query.sql");
    @PersistenceContext
    private final EntityManager manager;

    public ProductRepository(EntityManager manager) {
        this.manager = manager;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List find(String name) {
        return manager.createNativeQuery(sql).setParameter("name", name).getResultList();
    }
}