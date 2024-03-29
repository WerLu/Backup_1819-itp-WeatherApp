package JavaFX;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Ctrl {

    @FXML
    private AnchorPane Home;

    @FXML
    AnchorPane TemperatureCourse;

    @FXML
    AnchorPane Weather2;

    @FXML
    AnchorPane temp_forecast;

    @FXML
    AnchorPane linechartpane;

    @FXML
    AnchorPane linechartpane2;

    @FXML
    TextField textCity;

    @FXML
    TextField textCity2;

    public void loadFxml() throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("fxml2.fxml"));
        TemperatureCourse.getChildren().add(newLoadedPane);
        AnchorPane newLoadedPane2 = FXMLLoader.load(getClass().getResource("fxml3.fxml"));
        temp_forecast.getChildren().add(newLoadedPane2);
        AnchorPane newLoadedPane3 = FXMLLoader.load(getClass().getResource("fxml4.fxml"));
        Weather2.getChildren().add(newLoadedPane3);
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


    @FXML
    CategoryAxis xAxisLineChart = new CategoryAxis();
    @FXML
    NumberAxis yAxisLineChart = new NumberAxis();
    @FXML
    LineChart<String,Number> lc =
            new LineChart<String,Number>(xAxisLineChart,yAxisLineChart);


    /**
     * Following Methods clearCharts and setTempLC and doRequest by Lukas Werner
     *
     * The corresponding View "fxml3.fxml" is also by Lukas Werner
     *
     */
    private boolean firsttime = true;
    Gson gson = new Gson();

    public void clearCharts(){
        lc.getData().clear();
        linechartpane.getChildren().clear();
        textCity.setText("");
        firsttime = true;
    }

    public Weather.forecastWeather_JSON doRequest(String city) throws IOException {
        URL url = new URL("https://community-open-weather-map.p.rapidapi.com/forecast?q=" + textCity.getText() + "&units=metric");
        String json = Weather.GetRequest.getRequest(url);
        if (json == null) throw new HTTPException(200);
        Weather.forecastWeather_JSON forecastWeather = gson.fromJson(json, Weather.forecastWeather_JSON.class); //Convert JSON into Java Classes
        if(forecastWeather.cod == "200"){
            throw new NullPointerException("ey") ;
        } else {
            return forecastWeather;
        }
    }

    public void setTempLC() throws IOException {
        if (textCity.getText() == "") throw new NullPointerException("ey");

        try{
            Weather.forecastWeather_JSON forecastWeather = doRequest(textCity.getText());

            lc.setTitle("5 Day Weather Forecast");
            xAxisLineChart.setLabel("Time");
            yAxisLineChart.setLabel("Temperature in Celsius");


            XYChart.Series seriesLineChart = new XYChart.Series();
            seriesLineChart.setName(forecastWeather.city.name + ", " + forecastWeather.city.country);


            //populating the series with data
            for(int i = 0; i <= 39; i++) {
                String date_org = forecastWeather.list.get(i).dt_txt;
                double temp = forecastWeather.list.get(i).main.temp;

                String date = date_org.split("-")[2].split(" ")[0] + "." +
                        date_org.split("-")[1] + " - " +
                        date_org.split(" ")[1].split(":")[0] + ":" +
                        date_org.split(" ")[1].split(":")[1];
                //day = date_org.split("-")[2].split(" ")[0];
                //System.out.println(date + " Temp: " + temp + "\n");
                seriesLineChart.getData().add(new XYChart.Data(date, temp));
            }

            lc.getData().add(seriesLineChart);
            lc.setPrefWidth(900);

            if (firsttime == true){
                linechartpane.getChildren().addAll(lc);
                firsttime = false;
            }
        } catch (NullPointerException e) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("WARNING");
            a.setHeaderText("entered City is incorrect");
            a.setContentText("Please enter a valid City name!");
            a.showAndWait();
        } catch (HTTPException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERROR");
            a.setHeaderText("too many Requests");
            a.setContentText("Please try again later!");
            a.showAndWait();
        }

        textCity.setText("");

    }

}
