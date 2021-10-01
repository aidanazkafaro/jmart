package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Payment extends Invoice implements Transactor
{
    // instance variables - replace the example below with your own
    public Shipment shipment;
    public int productCount;
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment){
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    public double getTotalPay(){
        return 0.0;
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
