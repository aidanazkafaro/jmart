package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
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

    /**
     * Constructor for objects of class Product
     */
    public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
    {
        // initialise instance variables
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        rating = new ProductRating();
        this.id = ++idCounter;
    }


}
