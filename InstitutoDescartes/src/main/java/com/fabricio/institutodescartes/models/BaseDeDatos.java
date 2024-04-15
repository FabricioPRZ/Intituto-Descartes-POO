package com.fabricio.institutodescartes.models;

import java.util.ArrayList;

public interface BaseDeDatos {
    boolean save(Student student);
    boolean update(Student student);
    ArrayList<Student> getAllStudents();
    Student getStudentById(String studentId);
}