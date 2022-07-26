package UdemySwingCourse.controller;

import UdemySwingCourse.guiview.FormEvent;
import UdemySwingCourse.model.AgeCategory;
import UdemySwingCourse.model.Database;
import UdemySwingCourse.model.Person;
import UdemySwingCourse.model.Race;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Person> getPeople(){
        return db.getPeople();
    }
    public void addPerson(FormEvent ev){
        String name = ev.getName();
        String job = ev.getOccupation();
        int ageCat = ev.getAgeCategory();
        String race = ev.getRace().toUpperCase();

        AgeCategory ag = AgeCategory.ADULT;
        if(ageCat != ag.ordinal()){
            ag = (ageCat == AgeCategory.CHILD.ordinal())? AgeCategory.CHILD: AgeCategory.OLD;
        }

        Race raceR = Race.valueOf(race);
        //System.out.println(ag+ " "+ raceR);

        Person person = (getPeople()!= null) ? new Person(name, job, ag , raceR, getPeople().size()+1) : new Person(name, job, ag , raceR);

       //Person person = new Person(name, job, ag , raceR);
        db.addPerson(person);

       // System.out.println(person);
    }
    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }
    public void connect() throws Exception {
        db.connect();
    }
    public void saveSQL() throws SQLException {
        db.save();
    }

    public void close(){
        db.disconnect();
    }

    public void loadFromFile(File file) throws IOException{
        db.loadFromFile(file);
    }

    public void loadSQL() throws SQLException {
        db.load();
    }

    public void removePerson(int index){
         db.removeRow(index);
    }
}
