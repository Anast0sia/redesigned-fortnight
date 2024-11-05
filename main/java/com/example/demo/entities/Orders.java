package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    private int customer_id;
    private String product_name;
    private int amount;
}