public class City {
    String cityName;
    String regionName;

    public City(String cityName, String regionName) {
        this.cityName = cityName;
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
