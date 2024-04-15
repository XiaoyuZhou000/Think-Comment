module com.example.comment {
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
    requires java.datatransfer;
    requires java.desktop;
    requires opencsv;
    requires spring.core;

    opens com.example.comment to javafx.fxml;
    exports com.example.comment;
}