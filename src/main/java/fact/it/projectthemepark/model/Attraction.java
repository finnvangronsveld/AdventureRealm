package fact.it.projectthemepark.model;

/**
 * Finn Vangronsveld
 * r1043273
 */

public class Attraction {
    private String name;
    private String photo;
    private Staff responsible;

    public Attraction(String name, String photo, Staff responsible) {
        this.name = name;
        this.photo = photo;
        this.responsible = responsible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Staff getResponsible() {
        return responsible;
    }

    public void setResponsible(Staff responsible) {
        this.responsible = responsible;
    }
}

