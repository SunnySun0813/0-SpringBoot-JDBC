package org.example.springbootjdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class Student {
    private int id;
    private String name;
    private int mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
    }
}
