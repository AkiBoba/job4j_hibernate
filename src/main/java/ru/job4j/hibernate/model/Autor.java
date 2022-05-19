package ru.job4j.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Data
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Books> books = new HashSet<>();

    public static Autor of(String name) {
        Autor autor = new Autor();
        autor.name = name;
        return autor;
    }

}
