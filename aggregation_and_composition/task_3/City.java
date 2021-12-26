package aggregation_and_composition.task_3;

public class City {
    private String cityName;
    private boolean isCapital;
    private boolean isRegionalCenter;

    public City(String cityName, boolean isRegionalCenter, boolean isCapital) {
        this.cityName = cityName;
        this.isRegionalCenter = isRegionalCenter;
        this.isCapital = isCapital;
    }

    public City(String cityName, boolean isRegionalCenter) {
        this(cityName, isRegionalCenter, false);
    }

    public City(String cityName) {
        this(cityName, false, false);
    }

    public boolean isCapital() {
        return isCapital;
    }

    public boolean isRegionalCenter() {
        return isRegionalCenter;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        if (isCapital) {
            return "Capital " + cityName;
        } else if (isRegionalCenter) {
            return "Regional center " + cityName;
        } else {
            return cityName;
        }
    }
}