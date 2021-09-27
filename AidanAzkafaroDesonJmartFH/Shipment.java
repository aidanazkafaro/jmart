package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
{
    // instance variables - replace the example below with your own
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    public static class Duration
    {
        // instance variables - replace the example below with your own
        public static final Duration INSTANT = new Duration((byte)(1 << 0));
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 1));
        public static final Duration REGULER = new Duration((byte)(1 << 1));
        public static final Duration KARGO = new Duration((byte)(1 << 1));
        private byte bit;
        
        private Duration(byte bit)
        {
            this.bit = bit;
        }
          
    }
    
    public static class MultiDuration{
        
        private byte bit;
        
        public MultiDuration(byte... args){
            
            for(byte s:args)
            {
                this.bit = (byte)(this.bit|s);

            }
        }
        
        public boolean isDuration(Duration reference){
            if ((reference.bit & this.bit) != 0){
                return true;
            }
            
            return false;
            
        }
        
    }
    
    public boolean read (String content){
        return false;
    };
    
}
