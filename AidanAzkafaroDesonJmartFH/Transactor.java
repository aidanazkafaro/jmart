package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Transactor 
{
    // instance variables - replace the example below with your own
    /*
    public String time;
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }
 
    protected Transactor(int id, int buyerId, int storeId)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
        time = "Time";
        rating = Rating.NONE;
    }
    
    protected Transactor(int id, Account buyer, Store store)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }
    */
    public abstract boolean validate();
    public abstract Transactor perform();
    
    
    
  
}
