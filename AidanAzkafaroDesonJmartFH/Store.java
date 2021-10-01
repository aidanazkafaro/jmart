package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Store here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String name;
    public String address;
    public String phoneNumber;
    
    /**
     * Constructor for objects of class Store
     */
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        // initialise instance variables
        super(accountId); 
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber)
    {
        // initialise instance variables
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public boolean read (String content){
        return false;
    };
    
    public String toString(){
        return "name: " + this.name + "\n" + "address: " + this.address + "\n" + "phoneNumber: " + this.phoneNumber;
    }

}
