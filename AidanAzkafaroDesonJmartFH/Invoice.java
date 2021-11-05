package AidanAzkafaroDesonJmartFH;

import java.util.Date;
import java.util.ArrayList;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (Aidan Azkafaro Deson)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable
{
    // instance variables - replace the example below with your own
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history;
    
    public static enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD;
    }
    
    public static enum Status 
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    
    protected Invoice(int buyerId, int productId){
  
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay();
    
    public class Record{
        public Status status;
        public Date date;
        public String message;
        
    }
}
