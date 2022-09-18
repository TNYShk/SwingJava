package UdemySwingCourse.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Person> people;

    public Database() {
        people = new ArrayList<>();
    }

    public void addPerson(Person you){
        people.add(you);
    }

    public List<Person> getPeople(){
        return people;
    }
}
