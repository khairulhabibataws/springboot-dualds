package com.example.coolapp.model;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seg_generator")
    @SequenceGenerator(name = "seq_generator", sequenceName = "person_seq")
    private Long id;
    private String name;

    public Person(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
