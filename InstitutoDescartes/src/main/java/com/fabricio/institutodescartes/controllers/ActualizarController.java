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

public class ActualizarController {
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
    private Button searchButton;

    public void initFields(Student student) {
        idGenerated.setText(student.getId());
        name.setText(student.getName());
        lastName.setText(student.getLastName());
    }

    @FXML
    void onMouseClickExitButton(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickSearchButton(MouseEvent event) {
        String studentId = idGenerated.getText();

        System.out.println("ID del estudiante a buscar: " + studentId);

        Student foundStudent = mariaDB.getStudentById(studentId);
        if (foundStudent == null) {
            foundStudent = mySQL.getStudentById(studentId);
        }
        if (foundStudent == null) {
            foundStudent = sqlite.getStudentById(studentId);
        }

        if (foundStudent != null) {
            initFields(foundStudent);
        } else {
            mostrarAlertaError("No se encontró al estudiante con el ID proporcionado");
        }
    }


    @FXML
    void onMouseClickSaveButton(MouseEvent event) {
        String studentId = idGenerated.getText();
        String studentName = name.getText();
        String studentLastName = lastName.getText();

        Student existingStudent = mariaDB.getStudentById(studentId);
        if (existingStudent == null) {
            mostrarAlertaError("No se encontró al estudiante en la base de datos");
            return;
        }

        existingStudent.setName(studentName);
        existingStudent.setLastName(studentLastName);

        boolean successMariaDB = mariaDB.update(existingStudent);
        boolean successMySQL = mySQL.update(existingStudent);
        boolean successSQLite = sqlite.update(existingStudent);

        if (successMariaDB || successMySQL || successSQLite) {
            mostrarAlerta("El estudiante se ha modificado correctamente");
        } else {
            mostrarAlertaError("No se ha podido modificar al estudiante");
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
