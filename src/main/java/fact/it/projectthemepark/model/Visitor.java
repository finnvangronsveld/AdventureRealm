package fact.it.projectthemepark.model;

import java.util.ArrayList;

/**
 * Finn Vangronsveld
 * r1043273
 */

public class Visitor extends Person {
    private int yearOfBirth;
    private String themeParkCode = "undefined";
    private ArrayList<String> wishList = new ArrayList<>();

    public Visitor(String firstName, String surName, int yearOfBirth) {
        super(firstName, surName);
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getThemeParkCode() {
        return themeParkCode;
    }

    public void setThemeParkCode(String themeParkCode) {
        if (this.themeParkCode.equals("undefined")) {
            this.themeParkCode = themeParkCode;
        }
    }

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public boolean addToWishList(String attractionName) {
        if (wishList.size() < 5) {
            wishList.add(attractionName);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Visitor " + super.toString() + " with theme park code " + themeParkCode;
    }
}
