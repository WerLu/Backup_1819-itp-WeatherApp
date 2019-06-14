//package forecast;

public class Main {
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
