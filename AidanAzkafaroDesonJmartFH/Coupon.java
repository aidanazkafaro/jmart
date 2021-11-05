package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Coupon here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Coupon extends Recognizable
{
    // instance variables - replace the example below with your own
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    /**
     * Constructor for objects of class Coupon
     */
    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {
        // initialise instance variables
    
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    public boolean isUsed()
    {
        return used;
    }
    
    public boolean canApply(Treasury treasury)
    {
        if((treasury.getAdjustedPrice() > minimum) && !used)
        {
            return true;
        }
        
        return false;
        
    }
    
    public double apply(Treasury treasury)
    {
        used=true;
        if(type == Type.DISCOUNT) {
            return (treasury.getAdjustedPrice() - ((100-cut)/100));
        }
        
        return (treasury.getAdjustedPrice()-cut);
    }
    
    public enum Type
    {
        DISCOUNT, REBATE
    }   
    
}
