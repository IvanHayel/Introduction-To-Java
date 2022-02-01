package com.epam.introduction.aggregation_and_composition.task_3;

import java.util.ArrayList;
import java.util.List;

public class State {
    private String stateName;
    private List<Region> regions;

    public State(String stateName) {
        this.stateName = stateName;
        this.regions = new ArrayList<>();
    }

    public void addRegion(Region region) {
        regions.add(region);
    }

    public String getStateName() {
        return stateName;
    }

    public List<Region> getRegions() {
        return List.copyOf(regions);
    }

    public void displayCapital() {
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                for (City city : district.getCities()) {
                    if (city.isCapital()) {
                        System.out.println(city);
                        return;
                    }
                }
            }
        }
        System.out.println("There's no capital in this state.");
    }

    public void displayRegionsNumber() {
        System.out.println("Number of regions: " + regions.size());
    }

    public void displayTotalArea() {
        double totalArea = 0;
        for (Region region : regions) {
            totalArea += region.getArea();
        }
        System.out.println("Total area: " + totalArea);
    }

    public void displayRegionalCenters() {
        boolean isDisplayed = false;
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                for (City city : district.getCities()) {
                    if (city.isRegionalCenter()) {
                        System.out.println(city);
                        isDisplayed = true;
                    }
                }
            }
        }
        if (!isDisplayed) {
            System.out.println("There are no regional centers in this state.");
        }
    }
}