package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
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
    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean isUsed()
    {
        return this.used;
    }
    
    public boolean canApply(PriceTag priceTag)
    {
        if(!used)
        {
            return true;
        }else
        {
            return false;
        }
    }
    
    public boolean apply(PriceTag priceTag)
    {
        this.used = true;
        return this.used;
    }
    
    public static enum Type
    {
        DISCOUNT, REBATE
    }   
    
}
