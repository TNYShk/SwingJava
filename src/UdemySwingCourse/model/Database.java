package UdemySwingCourse.model;

import java.io.*;
import java.util.*;

public class Database {
    private LinkedList<Person> people;

    public Database() {
        people = new LinkedList<>();
    }

    public void addPerson(Person you){
        people.add(you);
    }

    public List<Person> getPeople(){
        return Collections.unmodifiableList(people);
    }


    public Person[] getPeopleArray(){
        return people.toArray(getPeople().toArray(new Person[people.size()]));
    }

    public void saveToFile(File file) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(getPeopleArray());

        oos.close();
    }

    public void loadFromFile(File file) throws IOException{

        try( FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            Person[] persons = (Person[]) ois.readObject();
            people.clear();

            people.addAll(Arrays.asList(persons));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
       ** older option needs explicit closure
       FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {

            Person[] persons = (Person[]) ois.readObject();
            people.clear();

            people.addAll(Arrays.asList(persons));

        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }

        ois.close();
       */
    }

    public void removeRow(int index){
        people.remove(index);
    }
}
