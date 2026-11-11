module com.mycompany.cetakdekat {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.cetakdekat to javafx.fxml;
    exports com.mycompany.cetakdekat;
}
