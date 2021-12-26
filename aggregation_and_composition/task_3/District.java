package aggregation_and_composition.task_3;

import java.util.ArrayList;
import java.util.List;

public class District {
    private String districtName;
    private List<City> cities;

    public District(String districtName) {
        this.districtName = districtName;
        cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public String getDistrictName() {
        return districtName;
    }

    public List<City> getCities() {
        return List.copyOf(cities);
    }
}