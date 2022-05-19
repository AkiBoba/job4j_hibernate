package ru.job4j.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public static Books of(String name) {
        Books books = new Books();
        books.name = name;
        return books;
    }
}
