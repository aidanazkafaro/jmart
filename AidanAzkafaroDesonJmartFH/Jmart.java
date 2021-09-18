package AidanAzkafaroDesonJmartFH;


/**
 *
 * @author (Aidan Azkafaro Deson/2006528862)
 * 
 */
public class Jmart
{

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
        float beforeFloat = before;
        float afterFloat = after;
        
        if(before < after)
        {
            return 0.0f;
        }
        return  ((beforeFloat-afterFloat)/beforeFloat)*100.0f;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        
        float priceFloat = price;
        
        if(discountPercentage > 100.0f)
        {
            return 0;
        }
        float hasil = priceFloat - (priceFloat * (discountPercentage/100));
        int hasilInt = (int)hasil;
        return hasilInt;
    
    } 
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        float discountedPriceFloat = discountedPrice;
        float hasil = (100.0f/(100.0f - discountPercentage)) * discountedPrice;
        return (int)hasil;
    }
    

    public static float getCommissionMultiplier()
    {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
        float priceFloat = price;
        float hasil = priceFloat + (priceFloat * getCommissionMultiplier());
        
        return (int)hasil;
    }
    
    public static int getAdminFee(int price)
    {
        float priceFloat = price;
        float hasil = priceFloat * getCommissionMultiplier();
        return (int)hasil;
    }
    
    public static Product create()
    {
        Product product = new Product("Baju Nike", 1, true, 10000.0, ProductCategory.FASHION);
        return product;
    }
    
    public static void main (String[]args){
        System.out.println(getDiscountPercentage(1000,900));
        System.out.println(getDiscountedPrice(1000,120.0f));
        System.out.println(getOriginalPrice(1000,0));
        System.out.println(getCommissionMultiplier());
        System.out.println(getAdjustedPrice(0));
        System.out.println(getAdminFee(500));
    }
    
}
