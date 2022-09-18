package UdemySwingCourse.model;

public enum AgeCategory {
    CHILD("Under 18"),ADULT("18-65"),OLD("Above 65");

    AgeCategory(String s) {
        this.s = s;
    }
    private final String s;

    public String getValue(){
        return s;
    }
    public int getIndex(){
        return this.ordinal();
    }
}
