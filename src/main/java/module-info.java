module org.example.concurrenciaproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.concurrenciaproyecto to javafx.fxml;
    exports org.example.concurrenciaproyecto;
}