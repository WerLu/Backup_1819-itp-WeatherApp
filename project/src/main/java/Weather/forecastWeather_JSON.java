package Weather;

import java.util.List;

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

class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;

    public Weather(int id, String main, String description, String icon){
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}

class Liste {
    public int dt;
    public Main main;
    public List<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public Rain rain;
    public Sys sys;
    public String dt_txt;

    public Liste(int dt, Main main, List<Weather> weather, Clouds clouds, Rain rain, Sys sys, String dt_txt){
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }
}

class Main {
    public double temp;
    public double temp_min;
    public double temp_max;
    public double pressure;
    public double sea_level;
    public double grnd_level;
    public int humidity;
    public double temp_kf;

    public Main(double temp, double temp_min, double temp_max, double pressure, double sea_level, double grnd_level, int humidity, double temp_kf) {
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.humidity = humidity;
        this.temp_kf = temp_kf;
    }
}

class Coord {
    public double lat;
    public double lon;

    public Coord(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }
}

class Sys {
    public String pod;

    public Sys(String pod) {
        this.pod = pod;
    }
}


class Wind {
    public double speed ;
    public double deg;

    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }
}

class Rain {
    public double __invalid_name__3h;

    public Rain(double __invalid_name__3h){
        this.__invalid_name__3h = __invalid_name__3h;
    }
}

class City {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;

    public City(int id, String name, Coord coord, String country, int population){
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
    }
}

class Clouds {
    public int all;

    public Clouds(int all){
        this.all = all;
    }
}
