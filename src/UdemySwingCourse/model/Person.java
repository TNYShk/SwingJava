package UdemySwingCourse.model;


import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 10l;
    private static int counter = 1 ;
    private final int ID;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private Race race;


    public Person(String name, String occupation, AgeCategory ageCategory, Race race) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.race = race;
        this.ID = counter++;
    }
    public Person(String name, String occupation, AgeCategory ageCategory, Race race, int count) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.race = race;
        this.ID = ++count;
       counter = count;
    }

    public String toString(){
        return (" "+ ID+ " "+ getName()+" "+getOccupation()+" "+getRace()+" "+ageCategory.name());
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

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getID(){
        return ID;
    }
}
