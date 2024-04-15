package com.fabricio.institutodescartes.controllers;

import com.fabricio.institutodescartes.models.BaseDeDatos;
import com.fabricio.institutodescartes.models.Student;
import com.fabricio.institutodescartes.models.MariaDB;
import com.fabricio.institutodescartes.models.MySQL;
import com.fabricio.institutodescartes.models.SQLite;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgregarController {
    private BaseDeDatos mariaDB = new MariaDB();
    private BaseDeDatos mySQL = new MySQL();
    private BaseDeDatos sqlite = new SQLite();

    @FXML
    private Button exitButton;

    @FXML
    private TextField idGenerated;

    @FXML
    private TextField lastName;

    @FXML
    private TextField name;

    @FXML
    private Button saveButton;

    @FXML
    void onMouseClickExitButton(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickSaveButton(MouseEvent event) {
        String studentName = name.getText();
        String studentLastName = lastName.getText();

        Student newStudent = new Student(studentName, studentLastName);

        boolean successMariaDB = mariaDB.save(newStudent);
        boolean successMySQL = mySQL.save(newStudent);
        boolean successSQLite = sqlite.save(newStudent);

        if (successMariaDB && successMySQL && successSQLite) {
            mostrarAlerta("El estudiante se ha agregado con éxito");
            idGenerated.setText(newStudent.getId());
            name.clear();
            lastName.clear();
        } else {
            mostrarAlertaError("No se ha podido agregar al estudiante");
        }
    }
    public void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public void mostrarAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
