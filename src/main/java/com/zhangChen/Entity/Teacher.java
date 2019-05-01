package com.zhangChen.Entity;

import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private List<c_class> classes;

    public List<c_class> getClasses() {
        return classes;
    }

    public void setClasses(List<c_class> classes) {
        this.classes = classes;
    }

    public Teacher() {

    }

    public Teacher(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return"Teacher [id=" + id + ", name=" + name + "]";
    }

}
