package AidanAzkafaroDesonJmartFH;


/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String date;
    public int buyerId;
    public int productId;
    public int complaintIdl;
    public Rating rating;
    public Status status;
    
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
        this.date = "0/0/0 (default)";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public double getTotalPay(){
        return 0.0;
    }
}
