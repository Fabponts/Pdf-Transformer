module org.example.pdftransformer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.pdfbox;
    requires org.apache.pdfbox.io;


    opens org.example.pdftransformer to javafx.fxml;
    exports org.example.pdftransformer;
    exports org.example.pdftransformer.controller;
    opens org.example.pdftransformer.controller to javafx.fxml;
}