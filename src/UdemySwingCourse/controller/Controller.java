package UdemySwingCourse.controller;

import UdemySwingCourse.guiview.FormEvent;
import UdemySwingCourse.guiview.FormPanel;
import UdemySwingCourse.model.AgeCategory;
import UdemySwingCourse.model.Database;
import UdemySwingCourse.model.Person;
import UdemySwingCourse.model.Race;

public class Controller {
    Database db = new Database();
    public void addPerson(FormEvent ev){

        String name = ev.getName();
        String job = ev.getOccupation();
        int ageCat = ev.getAgeCategory();

        String race = ev.getRace();


       // Person person = new Person(name, job, ageCat , race);
        //db.addPerson(person);
    }
}
