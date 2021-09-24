package AidanAzkafaroDesonJmartFH;


public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    private final int bit;
    
    private ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
    
    public ShipmentDuration (ShipmentDuration... args)
    {
        int tempBit = 0;
        for(ShipmentDuration s:args)
        {
            tempBit = tempBit | s.bit; 
        }
        
        this.bit = tempBit;
        
    }
    
    public boolean isDuration(ShipmentDuration reference)
    {
        int tempBit;
        if((reference.bit & INSTANT.bit) == INSTANT.bit)
        {
            return true;
        }else if((reference.bit & SAME_DAY.bit) == SAME_DAY.bit)
        {
            return true;
        }else if((reference.bit & NEXT_DAY.bit) == NEXT_DAY.bit)
        {
            return true;
        }else if((reference.bit & REGULER.bit) == REGULER.bit)
        {
            return true;
        }else if((reference.bit & KARGO.bit) == KARGO.bit)
        {
            return true;
        }

        return true;
    }
    
 
    
}
