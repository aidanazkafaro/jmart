package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Driver
     */
    public Driver()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public static int getPromo()
    {
        return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after)
    {
        if(before < after)
        {
            return 0.0f;
        }
        return  ((before-after)/before)*100;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        
        float priceFloat = price;
        if(discountPercentage > 100.0f)
        {
            return 0;
        }
        int hasil = price - (price* discountPercentage);
        return hasil;
    
    } 
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        return discountPrice + (100+discountPercentage)*;
    }
    
    public static float getCommissionMultiplier()
    {
        return 0.05f;
    }
    
    
    public static int getAdminFee(int price)
    {
        return price * int(getCommissionMultiplier());
    }
    
    public static void main (String[]args){
        System.out.println(getDiscountPercentage(1000,900));
        System.out.println("tes");
        
        System.out.println(getAdminFee(1000));
    }
    
}
