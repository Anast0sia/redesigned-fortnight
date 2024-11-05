package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
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