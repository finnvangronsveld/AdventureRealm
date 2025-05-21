package fact.it.projectthemepark.controller;

import fact.it.projectthemepark.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    private ArrayList<Staff> staffArrayList;
    private ArrayList<Visitor> visitorArrayList;
    private ArrayList<ThemePark> themeParkArrayList;

    private Visitor latestVisitor;

    @PostConstruct
    public void initializeData() {
        staffArrayList = fillStaffMembers();
        visitorArrayList = fillVisitors();
        themeParkArrayList = fillThemeParks();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/new-visitor")
    public String showNewVisitorForm() {
        return "1_newvisitor";
    }

    @PostMapping("/create-visitor")
    public String createVisitor(@RequestParam String firstName,
                                @RequestParam String surName,
                                @RequestParam int yearOfBirth,
                                Model model) {
        Visitor visitor = new Visitor(firstName, surName, yearOfBirth);
        this.latestVisitor = visitor;

        model.addAttribute("visitorInfo", visitor.toString());
        return "2_visitordetails";
    }

    private ArrayList<Staff> fillStaffMembers() {
        ArrayList<Staff> list = new ArrayList<>();
        list.add(new Staff("Johan", "Bertels", false));
        list.add(new Staff("An", "Van Herck", true));
        list.add(new Staff("Bruno", "Coenen", false));
        list.add(new Staff("Wout", "Dayaert", false));
        list.add(new Staff("Louis", "Petit", true));
        list.add(new Staff("Jean", "Pinot", false));
        list.add(new Staff("Ahmad", "Bezeri", false));
        list.add(new Staff("Hans", "Volzky", true));
        list.add(new Staff("Joachim", "Henau", false));
        return list;
    }

    private ArrayList<Visitor> fillVisitors() {
        ArrayList<Visitor> list = new ArrayList<>();
        Visitor v1 = new Visitor("Dominik", "Mioens", 2001);
        v1.addToWishList("The big wave");
        v1.addToWishList("Sky Scream");

        Visitor v2 = new Visitor("Zion", "Noops", 1996);
        v2.addToWishList("Pirate boat");
        v2.addToWishList("Sky Scream");
        v2.addToWishList("Halvar the ride");
        v2.addToWishList("DreamCatcher");

        Visitor v3 = new Visitor("Maria", "Bonetta", 1998);
        v3.addToWishList("DinoSplash");

        list.add(v1);
        list.add(v2);
        list.add(v3);
        return list;
    }

    private ArrayList<ThemePark> fillThemeParks() {
        ArrayList<ThemePark> list = new ArrayList<>();

        // Reuse staff list by index
        Staff s1 = staffArrayList.get(0);
        Staff s2 = staffArrayList.get(1);
        Staff s3 = staffArrayList.get(2);
        Staff s4 = staffArrayList.get(3);
        Staff s5 = staffArrayList.get(4);
        Staff s6 = staffArrayList.get(5);
        Staff s7 = staffArrayList.get(6);
        Staff s8 = staffArrayList.get(7);
        Staff s9 = staffArrayList.get(8);

        // Theme Parks
        ThemePark tp1 = new ThemePark("Plopsaland");
        ThemePark tp2 = new ThemePark("Walibi Belgium");
        ThemePark tp3 = new ThemePark("Holiday Park");

        // Attractions
        tp1.addAttraction(new Attraction("Anubis the Ride", "/img/anubis the ride.jpg", s1));
        tp1.addAttraction(new Attraction("The big wave", "/img/the big wave.jpg", s2));
        tp1.addAttraction(new Attraction("Pirate boat", "/img/pirate boat.jpg", s3));
        tp1.addAttraction(new Attraction("SuperSplash", "/img/supersplash.jpg", s4));

        tp2.addAttraction(new Attraction("Dancing fountains", "/img/dancing fountains.jpg", s5));
        tp2.addAttraction(new Attraction("Halvar the ride", "/img/halvar the ride.jpg", s6));

        tp3.addAttraction(new Attraction("DinoSplash", "/img/dinosplash.jpg", s7));
        tp3.addAttraction(new Attraction("Bounty Tower", "/img/bountytower.jpg", s8));
        tp3.addAttraction(new Attraction("Sky Scream", "/img/sky scream.jpg", s9));

        list.add(tp1);
        list.add(tp2);
        list.add(tp3);
        return list;
    }
}
