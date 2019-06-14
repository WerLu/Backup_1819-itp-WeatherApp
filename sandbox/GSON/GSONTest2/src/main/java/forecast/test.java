package forecast;

import com.google.gson.Gson;
import javafx.application.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String output = "Weather APP:\n\n";

        URL urlcur = new URL("https://community-open-weather-map.p.rapidapi.com/weather?id=2172797&units=metric&q=linz");
        URL urlforecast = new URL("https://community-open-weather-map.p.rapidapi.com/forecast?q=linz&units=metric");

        String json = GetRequest(urlforecast);

        System.out.println(json);

        forecastWeather_JSON forecastWeather = gson.fromJson(json, forecastWeather_JSON.class);
        output += "City: " + forecastWeather.city.name + "\n";
        output += "Time: " + forecastWeather.list.get(0).dt_txt+ "\n";
        output += "1st Temperature: " + forecastWeather.list.get(0)+ "\n";
        output += "2nd Temperature: " + forecastWeather.list.get(1).main.temp + "\n";
        output += "3rd Temperature: " + forecastWeather.list.get(2).main.temp + "\n";
        output += "4th Temperature: " + forecastWeather.list.get(3).main.temp + "\n";
        output += "5th Temperature: " + forecastWeather.list.get(4).main.temp + "\n";
        output += "6th Temperature: " + forecastWeather.list.get(5).main.temp + "\n";
        output += "7th Temperature: " + forecastWeather.list.get(6).main.temp + "\n";
        output += "8th Temperature: " + forecastWeather.list.get(7).main.temp + "\n";
        System.out.println(output);
    }

    public static String GetRequest(URL url) throws IOException {
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com");
        connection.setRequestProperty("X-RapidAPI-Key", "037ea10f45msh43d3dcf55ea5884p1a0253jsnc63de8255899");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            //System.out.println("JSON String Result " + response.toString());
            return response.toString();
        } else {
            System.out.println("GET NOT WORKED");
            return null;
        }
    }
}