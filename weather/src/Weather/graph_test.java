/*package Weather;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.net.URL;



public class graph_test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Gson gson = new Gson();
        String urlstr = "https://community-open-weather-map.p.rapidapi.com/forecast?q=linz&units=metric";
        URL url = new URL(urlstr); //create URL
        String json = GetRequest.getRequest(url); //HTTP Request
        System.out.println(json);
        System.out.println("\n\n\n\n\n\n\n\n");
        forecastWeather_JSON forecastWeather = gson.fromJson(json, forecastWeather_JSON.class); //Convert JSON into Java Classes

        primaryStage.setTitle("Line Chart Sample");

        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Temperature in Celsius");

        //creating the chart
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Weather Forecast " + forecastWeather.city.name + ", " + forecastWeather.city.country);

        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("5 days forecast");
        String day = "1000";
        //populating the series with data
        for(int i = 0; i <= 39; i++) {
            String date_org = forecastWeather.list.get(i).dt_txt;
            double temp = forecastWeather.list.get(i).main.temp;

            String date = date_org.split("-")[2].split(" ")[0] + "." +
                        date_org.split("-")[1] + " - " +
                        date_org.split(" ")[1].split(":")[0] + ":" +
                        date_org.split(" ")[1].split(":")[1];
            day = date_org.split("-")[2].split(" ")[0];
            System.out.println(date + " Temp: " + temp + "\n");
            series.getData().add(new XYChart.Data(date, temp));
        }

        Scene scene  = new Scene(lineChart,2000,3000);
        lineChart.getData().add(series);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args);}
}
*/