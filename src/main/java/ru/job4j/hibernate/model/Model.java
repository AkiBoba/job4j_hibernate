package ru.job4j.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;

    public static Model of(String name, Mark mark) {
        Model model = new Model();
        model.name = name;
        model.mark = mark;
        return model;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Model{"
                +
                "id=" + id
                +
                ", name='" + name + '\''
                +
                '}';
    }
}
