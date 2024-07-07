package com.example.jdbcDemo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/*
 This class represents a person entity in the database.
@Data - adds to the class getters, setters, no-args constructor, and methods equals, toString, hashCode
@Table("persons") - mapping table in the database for the person entity
The variables have the same names and types as the fields in the database
 */
@Data
@Table("persons")
public class Person {
    @Id // annotation for entity identifier
    private int id;
    private String name;
    private LocalDate birthday;
}
