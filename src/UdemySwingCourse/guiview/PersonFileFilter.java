package UdemySwingCourse.guiview;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {

        if(f.isDirectory())
            return true;

        String name = f.getName();
        String ext = Utils.getFileType(name);
        return ext != null && ext.equals("per");



    }

    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
}
