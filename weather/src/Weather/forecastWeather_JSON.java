package Weather;

import java.util.List;

/**
 * JSON Structure with all used Classes by Lukas Werner
 */
public class forecastWeather_JSON {
    public String cod;
    public double message;
    public int cnt;
    public List<Liste> list;
    public City city;

    public forecastWeather_JSON(String cod, double message, int cnt, List<Liste> list, City city){
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }
}