package UdemySwingCourse.guiview;

import UdemySwingCourse.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> db;
    private String[] colNames = {"ID","Name", "Occupation", "Age", "Race"};

    public void setData(List<Person>db){
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {

        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = db.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return person.getID();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCategory();
            case 4:
                return person.getRace();

        }
        return null;
    }
}
