package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public abstract class Recognizable
{
    // instance variables - replace the example below with your own
    public final int id;

    //constructor
    protected Recognizable(int id){
        this.id = id;
    }
    
    public boolean equals(Object object){
        
        return (object != null) && (object instanceof Recognizable) && (this.id == ((Recognizable) object).id);
    }
    
    public boolean equals(Recognizable recognizable){
        if(this.id == recognizable.id){
            return true;
        }
        return false;
    }
}