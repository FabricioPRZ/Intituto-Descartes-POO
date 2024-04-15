package com.fabricio.institutodescartes.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.fabricio.institutodescartes.Instituto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addRegistro;

    @FXML
    private Button exitButton;

    @FXML
    private Button seeRegistro;

    @FXML
    private Button updateRegistro;

    @FXML
    void onMouseClickAddRegistro(MouseEvent event) throws IOException {
        Stage add = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Instituto.class.getResource("AgregarView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        add.setTitle("Instituto Descartes / Agregar");
        add.setScene(scene);
        add.show();
    }

    @FXML
    void onMouseClickExitButton(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickSeeRegistro(MouseEvent event) throws IOException {
        Stage see = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Instituto.class.getResource("VerRegistroView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        see.setTitle("Instituto Descartes / Registros");
        see.setScene(scene);
        see.show();
    }

    @FXML
    void onMouseClickUpdateRegistro(MouseEvent event) throws IOException {
        Stage update = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Instituto.class.getResource("ActualizarView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        update.setTitle("Instituto Descartes / Actualizar");
        update.setScene(scene);
        update.show();
    }

    @FXML
    void initialize() {
    }

}
