package AidanAzkafaroDesonJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String desc;
    public String date;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    
   
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = sdf.format(new Date());
    }
    public boolean validate(){
        return false;
    }
    
    public Transactor perform(){
        return null;
    }
    
    public boolean read (String content){
        return false;
    };
}
