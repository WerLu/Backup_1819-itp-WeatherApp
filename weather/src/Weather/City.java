package Weather;//package forecast;

public class City {
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
