package com.example.thear.ecampus20.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    List<Semestr> semestrs;

    public Course() {
        semestrs = new ArrayList<>();
    }

    public List<Semestr> getSemestrs() {
        return semestrs;
    }

    public void setSemestrs(List<Semestr> semestrs) {
        this.semestrs = semestrs;
    }
}
