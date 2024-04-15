package com.fabricio.institutodescartes.models;

import java.util.ArrayList;

public class SQLite implements BaseDeDatos {
    private static ArrayList<Student> students = new ArrayList<>();

    @Override
    public boolean save(Student student) {
        return students.add(student);
    }

    @Override
    public boolean update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            Student existingStudent = students.get(i);
            if (existingStudent.getId().equals(student.getId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
