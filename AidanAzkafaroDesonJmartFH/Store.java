package AidanAzkafaroDesonJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static final String REGEX_PHONE = "^(\\d{9,12})$";
    public static final String REGEX_NAME = "^(^([A-Za-z]{4,20}).([A-Za-z]{0,20})$)$";
    
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
    
    public boolean validate(){
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        boolean matchFoundName = matcherName.find();
        
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();
        
        if(matchFoundName && matchFoundPhone){
            return true;
        }
        return false;
        
    }

}
