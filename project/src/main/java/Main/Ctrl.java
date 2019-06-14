package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

public class Ctrl {

    @FXML
    private AnchorPane Home;

    @FXML
    AnchorPane TemperatureCourse;

    @FXML
    AnchorPane Weather3;

    @FXML
    LineChart Chart1;

    public void loadFxml() throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("fxml2.fxml"));
        TemperatureCourse.getChildren().add(newLoadedPane);
        /*TabPane newLoadedPane2 = FXMLLoader.load(getClass().getResource("fxml2.fxml"));
        TemperatureCourse.getChildren().add(newLoadedPane2);
        TabPane newLoadedPane3 = FXMLLoader.load(getClass().getResource("fxml3.fxml"));
        TemperatureCourse.getChildren().add(newLoadedPane3);*/
    }

    @FXML
    CategoryAxis xAxis = new CategoryAxis();
    @FXML
    NumberAxis yAxis = new NumberAxis();
    @FXML
    BarChart<String,Number> bc =
            new BarChart<String,Number>(xAxis,yAxis);
    public void setBc(){
        final  String austria = "Austria";
        final  String brazil = "Brazil";
        final  String france = "France";
        final  String italy = "Italy";
        final  String usa = "USA";

        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(austria, 25601.34));
        series1.getData().add(new XYChart.Data(brazil, 20148.82));
        series1.getData().add(new XYChart.Data(france, 10000));
        series1.getData().add(new XYChart.Data(italy, 35407.15));
        series1.getData().add(new XYChart.Data(usa, 12000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));
        bc.getData().addAll(series1, series2, series3);
    }


}
