package AidanAzkafaroDesonJmartFH;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (Aidan Azkafaro Deson)
 * @version (version number or date here)
 */
public abstract class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId = -1;
    public Rating rating = Rating.NONE;
    public Status status;
    public ArrayList<Record> history;
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static enum Rating
    {
        BAD, GOOD, NEUTRAL, NONE;
    }
    
    public static enum Status 
    {
    	CANCELLED, COMPLAINT, DELIVERED, FAILED, FINISHED, ON_DELIVERY, ON_PROGRESS, WAITING_CONFIRMATION;
    }
    
    protected Invoice(int buyerId, int productId){
  
        this.date = new Date();
		this.buyerId = buyerId;
        this.productId = productId;
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay(Product product);
    
    public class Record{
        public Status status;
        public Date date;
        public String message;
        
    }
}
