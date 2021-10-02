package AidanAzkafaroDesonJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (Aidan Azkafaro Deson)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    public static enum Rating
    {
        NONE, BAD, NEUTRAL, GOOD;
    }
    
    public static enum Status 
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = sdf.format(new Date());
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay();
    
    public boolean read (String content){
        return false;
    };
}
