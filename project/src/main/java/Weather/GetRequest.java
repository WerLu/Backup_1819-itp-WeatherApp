package Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest {

    public String GetRequest(URL url) throws IOException {
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
