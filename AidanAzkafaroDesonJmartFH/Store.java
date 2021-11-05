package AidanAzkafaroDesonJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Store extends Recognizable
{
    // instance variables - replace the example below with your own
    public String name;
    public String address;
    public double balance;
    public String phoneNumber;
    public static final String REGEX_PHONE = "^(\\d{9,12})$";
    public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
    
    /**
     * Constructor for objects of class Store
     */

    public Store(String name, String address, String phoneNumber, double balance)
    {
        // Initialize instance variables
  
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    
 
    
    public String toString(){
        return "name: " + (String)this.name + "\n" + "address: " + (String)this.address + "\n" + "Phone Number" + (String)this.phoneNumber;
    }
    
    public boolean validate(){
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        boolean matchFoundName = matcherName.find();
        boolean nameResult = matchFoundName ? true : false;
        
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();
        boolean phoneResult = matchFoundPhone ? true : false;
        
        if(nameResult && phoneResult){
            return true;
        }
        return false;
        
    }

}
