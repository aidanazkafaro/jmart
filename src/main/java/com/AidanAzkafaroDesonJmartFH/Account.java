package com.AidanAzkafaroDesonJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;
    public static final String REGEX_EMAIL = "^\\\\w+([.&`~-]?\\\\w+)*@\\\\w+([.-]?\\\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d][^-\\\\s]{8,}$";
  
    public Account (String name, String email, String password, double balance){
        
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
  
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchFoundEmail = matcherEmail.find();
        boolean emailResult = matchFoundEmail ? true : false;
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        boolean passwordResult = matchFoundPassword ? true : false;
        
        if(emailResult && passwordResult){
            return true;
        }
        return false;
        
    }
}
