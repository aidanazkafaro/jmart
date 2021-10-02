package AidanAzkafaroDesonJmartFH;
import java.util.ArrayList;


/**
 * Write a description of class Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        
        less = false;
        
        ArrayList<PriceTag>priceTags = new ArrayList<PriceTag>();
        if(less == true){
            for(int i = 0; i < list.length; i++){
                double temp = list[i].getAdjustedPrice();
                if(list[i].getAdjustedPrice() < value){
                    priceTags.add(new PriceTag(temp));
                }
                
            }
        }else if (less == false){
            for(int i = 0; i < list.length; i++){
                double temp = list[i].getAdjustedPrice();
                if(list[i].getAdjustedPrice() >= value){
                    priceTags.add(new PriceTag(temp));
                }
                
            }
        }
        
        return priceTags;
        
    }
    
    public void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        
    }
}
