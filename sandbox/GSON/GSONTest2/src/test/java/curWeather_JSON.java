import java.util.List;

public class curWeather_JSON {
    //{"coord":{"lon":14.29,"lat":48.31},"weather":[{"id":520,"main":"Rain","description":"light intensity shower rain","icon":"09d"}],"base":"stations","main":{"temp":282.63,"pressure":1009,"humidity":81,"temp_min":279.82,"temp_max":284.26},"visibility":10000,"wind":{"speed":5.1,"deg":250},"clouds":{"all":75},"dt":1556873388,"sys":{"type":1,"id":6874,"message":0.0052,"country":"AT","sunrise":1556854874,"sunset":1556907488},"id":2772400,"name":"Linz","cod":200}

    public Coord coord;
    public List<Weather> weather;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int id;
    public String name;
    public int cod;

    public curWeather_JSON(Coord coord, List<Weather> weather, Main main, int visibility, Clouds clouds, int dt, Sys sys, int id, String name, int cod){
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }
}

