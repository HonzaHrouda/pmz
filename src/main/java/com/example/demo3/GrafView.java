package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class GrafView {

    @FXML
    private TextField Do;

    @FXML
    private TextField Od;

    @FXML
    private LineChart <Number, Number> graf;

    @FXML
    private TextField pocetBodu;


    @FXML
    void vykresliGraf(MouseEvent event) {


        graf.getData().clear();
        double tmp = Double.parseDouble(String.valueOf(pocetBodu.getText()));

        int n = (int)Math.round(tmp);
        double from = Double.parseDouble(Od.getText());
        double to = Double.parseDouble(Do.getText());

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i <= n; i++) {
            double x = from + i * (to - from)/n;
            series.getData().add(new XYChart.Data<>(x, Math.sin(x)));
        }
        series.setName("y = sin(x)");

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        for (int i = 0; i <= n; i++) {
            double x = from + i * (to - from)/n;
            series2.getData().add(new XYChart.Data<>(x, Math.cos(x)));
        }
        series2.setName("y = cos(x)");

        graf.getData().add(series);
        graf.getData().add(series2);



    }

}
