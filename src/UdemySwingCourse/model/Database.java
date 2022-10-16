package UdemySwingCourse.model;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database {
    private LinkedList<Person> people;
    private  Connection connection;

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
    }

    public void removeRow(int index) {
       /* String deleteRowSQL = "delete from people where id=?";
        PreparedStatement deletestmt = connection.prepareStatement(deleteRowSQL);
        */
        people.remove(index);
    }

    public void connect() throws Exception {
        if(connection !=null)
            return;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Driver not found");
        }
        String connectionUTL = "jdbc:mysql://root@localhost:3306/swingudemy";
        connection = DriverManager.getConnection(connectionUTL,"root","");

        System.out.println("connected "+ connection);
    }

    public void disconnect(){
        System.out.println("disconnected");
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void save() throws SQLException{
        String checkSQL = "select count(*) as count from people where id=?";
        PreparedStatement checkstmt = connection.prepareStatement(checkSQL);

        String insertSQl = "insert into people (id, name, job, age, race) values (?, ?, ?, ?, ?)";
        PreparedStatement insertstmt = connection.prepareStatement(insertSQl);

        String updateSQL = "update people set name=?, job=?, age=?, race=? where id=?";
        PreparedStatement updatestmt = connection.prepareStatement(updateSQL);

        String deleteRowSQL = "delete from people where id=?";
        PreparedStatement deletestmt = connection.prepareStatement(deleteRowSQL);

        for(Person person: people){
            int id = person.getID();
            String name = person.getName();
            String job = person.getOccupation();
            AgeCategory age = person.getAgeCategory();
            Race race = person.getRace();

            //search for 1st wildcard, and replace it with statement taken from id
            checkstmt.setInt(1,id);
            ResultSet checkResult = checkstmt.executeQuery();
            checkResult.next();

            int count = checkResult.getInt(1);
            if(count == 0){
                int col = 1;
                insertstmt.setInt(col++,id);
                insertstmt.setString(col++,name);
                insertstmt.setString(col++,job);
                insertstmt.setString(col++,age.name());
                insertstmt.setString(col++,race.name());

                insertstmt.executeUpdate();

                System.out.println("Inserted person with ID "+ id);
            }else{
                System.out.println("Updating person with ID "+ id);
                int col = 1;

                updatestmt.setString(col++,name);
                updatestmt.setString(col++,job);
                updatestmt.setString(col++,age.name());
                updatestmt.setString(col++,race.name());
                updatestmt.setInt(col++,id);
                updatestmt.executeUpdate();
            }
        }
        updatestmt.close();
        insertstmt.close();
        checkstmt.close();
    }

    public void load() throws SQLException {
        people.clear();
        String sql = "select id, name, job, age, race from people order by id";
        Statement selectstmt = connection.createStatement();

        ResultSet results = selectstmt.executeQuery(sql);
        while(results.next()){
            int iD = results.getInt("id");

            String name = results.getString("name");
            String occupation = results.getString("job");
            String age = results.getString("age");
            String race = results.getString("race");
            //Person toAdd = new Person(name)
            System.out.println("id: "+iD+ " name: "+ name+" is an "+age+ " "+occupation+ " and belongs to "+ race+" race");
        }

        selectstmt.close();


    }

}
