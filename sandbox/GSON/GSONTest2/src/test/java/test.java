import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String output = "Weather APP:\n\n";

        URL url = new URL("https://community-open-weather-map.p.rapidapi.com/weather?id=2172797&units=metric&q=linz");

        String json = GetRequest(url);

        //System.out.println(json);

        curWeather_JSON curWeather = gson.fromJson(json, curWeather_JSON.class);
        output += "City: " + curWeather.name + "\n";
        output += "Current Temperature: " + curWeather.main.temp + "\n";
        output += "Max Temperature: " + curWeather.main.temp_max + "\n";
        output += "Min Temperature: " + curWeather.main.temp_min + "\n";
        System.out.println(output);
    }

    public static String GetRequest(URL url) throws IOException {
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com"); // set userId its a sample here
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