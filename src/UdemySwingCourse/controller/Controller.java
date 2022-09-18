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
        AgeCategory ag = AgeCategory.ADULT;
        if(ageCat != ag.ordinal()){
            ag = (ageCat == AgeCategory.CHILD.ordinal())? AgeCategory.CHILD: AgeCategory.OLD;
        }
        Race raceR = Race.valueOf(race);


        System.out.println(ag+ " "+ raceR);

       Person person = new Person(name, job, ag , raceR);
        db.addPerson(person);
    }
}
