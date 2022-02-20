module com.example.calculadorajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculadorajavafx to javafx.fxml;
    exports com.example.calculadorajavafx;
}