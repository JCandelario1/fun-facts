package com.example.basicrestapi3;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "fun_facts")
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fact;
    private OffsetDateTime createdAt;
    private String isActive;

    public Fact() {}

    public Fact(String fact, OffsetDateTime createdBy, String isActive) {
        this.fact = fact;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public OffsetDateTime getCreatedBy() {
        return createdAt;
    }

    public void setCreatedBy(OffsetDateTime createdBy) {
        this.createdAt = createdBy;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
