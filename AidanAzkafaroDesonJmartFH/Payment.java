package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Payment extends Invoice 
{
    // instance variables - replace the example below with your own
    public Shipment shipment;
    public int productCount;
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    public double getTotalPay(){
        return 0.0;
    }
    
}
