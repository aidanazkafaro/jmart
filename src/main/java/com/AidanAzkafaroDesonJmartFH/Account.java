package com.AidanAzkafaroDesonJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;


/**
 * Class Account yang digunakan untuk pembuatan akun dan validasi data akun
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{7,}$";
    public double balance;
    public String email, name, password;
    public Store store;

    /**
     * Constructor pembuatan akun untuk inisialisasi data awal akun
     * @param name
     * @param email
     * @param password
     * @param balance
     */
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Method untuk mengecek kesesuaian input email dan password dengan regexnya 
     */
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchEmail = matcherEmail.find();
        boolean hasilEmail = matchEmail ? true : false;

        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchPassword = matcherPassword.find();
        boolean hasilPassword = matchPassword ? true : false;

        if (hasilEmail == true && hasilPassword == true){
            return true;
        }
        else
            return false;
    }
}