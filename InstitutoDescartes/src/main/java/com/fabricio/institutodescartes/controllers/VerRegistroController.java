package com.fabricio.institutodescartes.controllers;

import com.fabricio.institutodescartes.models.BaseDeDatos;
import com.fabricio.institutodescartes.models.Student;
import com.fabricio.institutodescartes.models.MariaDB;
import com.fabricio.institutodescartes.models.MySQL;
import com.fabricio.institutodescartes.models.SQLite;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class VerRegistroController {

    private BaseDeDatos mariaDB = new MariaDB();
    private BaseDeDatos mySQL = new MySQL();
    private BaseDeDatos sqlite = new SQLite();

    @FXML
    private Button exitButton;

    @FXML
    private ListView<String> mariadbList;

    @FXML
    private ListView<String> mysqlList;

    @FXML
    private ListView<String> sqliteList;

    @FXML
    void onMouseClickExitButton(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        loadStudents(mariaDB.getAllStudents(), mariadbList);
        loadStudents(mySQL.getAllStudents(), mysqlList);
        loadStudents(sqlite.getAllStudents(), sqliteList);
    }

    private void loadStudents(List<Student> students, ListView<String> listView) {
        for (Student student : students) {
            String studentInfo = "ID: " + student.getId() + ", Nombre: " + student.getName() + " " + student.getLastName();
            listView.getItems().add(studentInfo);
        }
    }
}
