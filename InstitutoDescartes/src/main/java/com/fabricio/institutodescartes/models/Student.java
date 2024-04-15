package com.fabricio.institutodescartes.models;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty lastName;
    private static int idCounter = 1000;

    public Student(String name, String lastName) {
        this.id = new SimpleStringProperty(generateId());
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
    }

    private String generateId() {
        return String.format("%06d", idCounter++);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
}
