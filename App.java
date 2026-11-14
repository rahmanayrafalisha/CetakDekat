package com.mycompany.cetakdekat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                App.class.getResource("primary.fxml")
        );

        Scene scene = new Scene(loader.load(), 850, 700);

        stage.setTitle("CetakDekat - Katalog Fotocopy");
        stage.setScene(scene);

        stage.setWidth(850);
        stage.setHeight(700);
        stage.setMinWidth(750);
        stage.setMinHeight(600);

        stage.centerOnScreen();
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
