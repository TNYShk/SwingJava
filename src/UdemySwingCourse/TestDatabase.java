package UdemySwingCourse;

import UdemySwingCourse.model.AgeCategory;
import UdemySwingCourse.model.Database;
import UdemySwingCourse.model.Person;
import UdemySwingCourse.model.Race;

import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args) {
            System.out.println("hello welcome");

        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.addPerson(new Person("Solomun","DJ", AgeCategory.ADULT, Race.HUMAN));
        db.addPerson(new Person("Sue","Lion tamer", AgeCategory.OLD, Race.ELF));
        db.addPerson(new Person("Sue","Artist", AgeCategory.OLD, Race.DROID));
        try {
            db.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            db.load();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        db.disconnect();
    }
}
