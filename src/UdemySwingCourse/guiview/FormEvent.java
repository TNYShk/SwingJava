package UdemySwingCourse.guiview;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategory;
    private String race;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source) {
        super(source);
    }
    public FormEvent(Object source,String name, String occupation, int ageCat,String race) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCat;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public int getAgeCategory(){
        return ageCategory;
    }
    public String getRace(){
        return race;
    }
}
