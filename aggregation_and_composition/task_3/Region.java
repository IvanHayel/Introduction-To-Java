package aggregation_and_composition.task_3;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String regionName;
    private List<District> districts;
    private double area;

    public Region(String regionName, double area) {
        this.regionName = regionName;
        this.districts = new ArrayList<>();
        this.area = area;
    }

    public void addDistrict(District district) {
        districts.add(district);
    }

    public String getRegionName() {
        return regionName;
    }

    public double getArea() {
        return area;
    }

    public List<District> getDistricts() {
        return List.copyOf(districts);
    }
}