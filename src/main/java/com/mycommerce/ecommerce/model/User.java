package com.mycommerce.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    private Long id;
    private String name;
    // getters and setters
}
