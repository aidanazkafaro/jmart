package AidanAzkafaroDesonJmartFH;


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
   
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = "0/0/0 (default)";
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
