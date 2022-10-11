package UdemySwingCourse.guiview;

public class Utils {
    public static String getFileType(String filename){
        String extension = null;
        if(filename.contains(".")){
            extension = filename.substring(filename.lastIndexOf('.') + 1);
        }

        return extension;
    }

    public static void main(String[] args){
        System.out.println(getFileType(".bla.text"));
    }
}
