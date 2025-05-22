/**
 * Finn Vangronsveld
 * r1043273
 */

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
    public String showNewVisitorForm(Model model) {
        model.addAttribute("themeParks", themeParkArrayList);
        return "1_newvisitor";
    }


    @PostMapping("/create-visitor")
    public String createVisitor(@RequestParam String firstName,
                                @RequestParam String surName,
                                @RequestParam int yearOfBirth,
                                @RequestParam int parkIndex,
                                Model model) {

        Visitor visitor = new Visitor(firstName, surName, yearOfBirth);
        ThemePark selectedPark = themeParkArrayList.get(parkIndex);
        selectedPark.registerVisitor(visitor);
        visitorArrayList.add(visitor);

        model.addAttribute("visitorInfo", visitor.toString());
        return "2_visitordetails";
    }

    @GetMapping("/new-staff")
    public String showNewStaffForm() {
        return "3_newstaff";
    }

    @PostMapping("/create-staff")
    public String createStaff(@RequestParam String firstName,
                              @RequestParam String surName,
                              @RequestParam(required = false) boolean isStudent,
                              Model model) {
        Staff staff = new Staff(firstName, surName, isStudent);
        staffArrayList.add(staff);
        model.addAttribute("staffInfo", staff.toString());
        return "4_staffdetails";
    }

    @GetMapping("/all-staff")
    public String showAllStaff(Model model) {
        model.addAttribute("staffList", staffArrayList);
        return "5_staff";
    }

    @GetMapping("/all-visitors")
    public String showAllVisitors(Model model) {
        model.addAttribute("visitorList", visitorArrayList);
        return "6_visitors";
    }

    @GetMapping("/new-themepark")
    public String showNewThemeParkForm() {
        return "7_newthemepark";
    }

    @PostMapping("/create-themepark")
    public String createThemePark(@RequestParam String name) {
        themeParkArrayList.add(new ThemePark(name));
        return "redirect:/themeparks";
    }

    @GetMapping("/themeparks")
    public String showThemeParks(Model model) {
        model.addAttribute("parks", themeParkArrayList);
        return "8_themeparks";
    }

    @GetMapping("/new-attraction")
    public String showNewAttractionForm(Model model) {
        model.addAttribute("parks", themeParkArrayList);
        model.addAttribute("staff", staffArrayList);
        return "9_newattraction";
    }

    @PostMapping("/create-attraction")
    public String createAttraction(@RequestParam String name,
                                   @RequestParam String photo,
                                   @RequestParam int parkIndex,
                                   @RequestParam int staffIndex,
                                   Model model) {

        if (parkIndex < 0 || parkIndex >= themeParkArrayList.size() ||
                staffIndex < 0 || staffIndex >= staffArrayList.size()) {
            model.addAttribute("errorMessage", "Invalid theme park or staff selection.");
            return "error";
        }

        ThemePark selectedPark = themeParkArrayList.get(parkIndex);
        Staff responsible = staffArrayList.get(staffIndex);
        Attraction newAttraction = new Attraction(name, photo, responsible);
        selectedPark.addAttraction(newAttraction);

        model.addAttribute("selectedPark", selectedPark);
        return "10_showattractions";
    }

    @GetMapping("/search-attraction")
    public String searchAttraction(@RequestParam String search, Model model) {
        for (ThemePark park : themeParkArrayList) {
            Attraction found = park.searchAttractionByName(search);
            if (found != null) {
                model.addAttribute("attraction", found);
                model.addAttribute("parkName", park.getName());
                return "11_attractiondetails";
            }
        }
        model.addAttribute("errorMessage", "Attraction '" + search + "' not found.");
        return "error";
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

        Staff s1 = staffArrayList.get(0);
        Staff s2 = staffArrayList.get(1);
        Staff s3 = staffArrayList.get(2);
        Staff s4 = staffArrayList.get(3);
        Staff s5 = staffArrayList.get(4);
        Staff s6 = staffArrayList.get(5);
        Staff s7 = staffArrayList.get(6);
        Staff s8 = staffArrayList.get(7);
        Staff s9 = staffArrayList.get(8);

        ThemePark tp1 = new ThemePark("Plopsaland");
        ThemePark tp2 = new ThemePark("Walibi Belgium");
        ThemePark tp3 = new ThemePark("Holiday Park");

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
