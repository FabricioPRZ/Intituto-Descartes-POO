package com.fabricio.institutodescartes.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fabricio.institutodescartes.Instituto;
import com.fabricio.institutodescartes.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    private Button exitButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField user;
    User docente = new User();
    Stage instituto = new Stage();

    @FXML
    void onMouseClickEnterButton(MouseEvent event) throws IOException {
        String usuario = user.getText();
        String contrasena = password.getText();

        if (usuario.equals(docente.getUsername()) && contrasena.equals(docente.getPassword())){
            FXMLLoader fxmlLoader = new FXMLLoader(Instituto.class.getResource("MenuView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            instituto.setTitle("Instituto Descartes / Menú");
            instituto.setScene(scene);
            instituto.show();
        } else {
            mostrarAlerta();
        }
    }

    @FXML
    void onMouseClickExitButton(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

    public void mostrarAlerta () {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Las credenciales no coinciden, intentalo de nuevo");

        alert.showAndWait();
    }

}
