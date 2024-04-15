module com.fabricio.institutodescartes {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.fabricio.institutodescartes to javafx.fxml;
    exports com.fabricio.institutodescartes;
    exports com.fabricio.institutodescartes.models;
    opens com.fabricio.institutodescartes.models to javafx.fxml;
    exports com.fabricio.institutodescartes.controllers;
    opens com.fabricio.institutodescartes.controllers to javafx.fxml;
}