package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable
{
    // instance variables - replace the example below with your own
    private static int idCounter;
    private int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;

    /**
     * Constructor for objects of class Product
     */
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        // initialise instance variables
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        rating = new ProductRating();
        this.id = ++idCounter;
    }
    
    public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        // initialise instance variables
        this.id = id;
        this.storeId = store;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        rating = new ProductRating();
        this.id = ++idCounter;
    }

    public boolean read (String){
        
    }

}
