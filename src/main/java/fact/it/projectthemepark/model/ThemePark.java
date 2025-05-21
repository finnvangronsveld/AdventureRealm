package fact.it.projectthemepark.model;

import java.util.ArrayList;

/**
 * Finn Vangronsveld
 * r1043273
 */

public class ThemePark {
    private String name;
    private int numberOfVisitors;
    private ArrayList<Attraction> attractions = new ArrayList<>();

    public ThemePark(String name) {
        this.name = name;
        this.numberOfVisitors = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public int getNumberOfAttractions() {
        return attractions.size();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public Attraction searchAttractionByName(String name) {
        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    public void registerVisitor(Visitor visitor) {
        numberOfVisitors++;
        if (visitor.getThemeParkCode().equals("undefined")) {
            String code = name.substring(0, 2) + numberOfVisitors;
            visitor.setThemeParkCode(code);
        }
    }
}
