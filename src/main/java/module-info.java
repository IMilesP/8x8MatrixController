module com.imilesp.tesmart8x8matrixcontroller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.imilesp.tesmart8x8matrixcontroller to javafx.fxml;
    exports com.imilesp.tesmart8x8matrixcontroller;
}