package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloController {


    @FXML
    private Canvas platno = new Canvas(1000,800);

    @FXML
    void spustCanvas(MouseEvent event) throws IOException {

        GraphicsContext gc = platno.getGraphicsContext2D();
        double x = 50, y = 50;
        double length = 500; // Délka první čáry

        // Směr spirály (0 = doprava, 1 = dolů, 2 = doleva, 3 = nahoru)
        int direction = 0;

        // Krok pro zmenšení délky čáry
        double step = 15;

        while (length > 0) {
            switch (direction % 4) {
                case 0:
                    gc.strokeLine(x, y, x + length, y); //vpravo
                    x += length;
                    break;
                case 1:
                    gc.strokeLine(x, y, x, y + length); //dolů
                    y += length;
                    break;
                case 2:
                    gc.strokeLine(x, y, x - length, y);//vlevo
                    x -= length;
                    break;
                case 3:
                    gc.strokeLine(x, y, x, y - length);//nahoru
                    y -= length;
                    break;
            }
            direction++;
            length -= step;
        }
        Pane root = new Pane();
        root.getChildren().add(platno);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Canvas Graphics Example");
        stage.show();
    }

    @FXML
    void spustGraf(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("graf-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void zkopirujDoSchranky(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("clipboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

}
