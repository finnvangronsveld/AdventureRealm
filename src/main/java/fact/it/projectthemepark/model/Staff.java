package fact.it.projectthemepark.model;

import java.time.LocalDate;

/**
 * Finn Vangronsveld
 * r1043273
 */

public class Staff extends Person {
    private LocalDate startDate;
    private boolean student;

    public Staff(String firstName, String surName, boolean student) {
        super(firstName, surName);
        this.startDate = LocalDate.now();
        this.student = student;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public String toString() {
        String info = "Staff member " + super.toString();
        if (student) {
            info += " (working student)";
        }
        info += " is employed since " + startDate.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return info;
    }
}
