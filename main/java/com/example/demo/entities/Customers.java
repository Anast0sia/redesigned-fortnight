package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Customers {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private int age;
    private long phone_number;
    @OneToMany
    private List<Orders> orders;
}