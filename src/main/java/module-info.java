module com.example.chess2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.chess2 to javafx.fxml;
    //exports com.example.chess2;
    exports com.example.chess2.ui;
    opens com.example.chess2.ui to javafx.fxml;
}