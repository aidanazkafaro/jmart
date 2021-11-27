package com.AidanAzkafaroDesonJmartFH.controller;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.JsonTable;
import com.AidanAzkafaroDesonJmartFH.Store;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
	public static final String REGEX_EMAIL = "^\\\\w+([.&`~-]?\\\\w+)*@\\\\w+([.-]?\\\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d][^-\\\\s]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

	@JsonAutowired(filepath = "C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\jsonFiles\\randomProductList.json", value = Account.class)
	public static JsonTable<Account> accountTable;

	 @Override
	    public JsonTable<Account> getJsonTable()
	    {
	        return accountTable;
	    }

	    @GetMapping("/account")
	    String index() { return "account page"; }

	    @GetMapping("/page")
	    public List<Account> getPage(int page, int pageSize) {
	        return getJsonTable().subList(page, pageSize);
	    }

	    @PostMapping("/login")
	    public Account login
	            (
	                    @RequestParam String email,
	                    @RequestParam String password
	            )
	    {
	        String passwordEnkripsi = null;

	        try
	        {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(password.getBytes());
	            byte[] bytes = md.digest();

	            StringBuilder sb = new StringBuilder();
	            for (byte aByte : bytes) {
	                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
	            }
	            passwordEnkripsi = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }

	        for(Account account : getJsonTable())
	        {
	            if(account.email.equals(email) && account.password.equals(passwordEnkripsi))
	            {
	                return account;
	            }
	        }
	        return null;
	    }

	    @PostMapping("/register")
	    public Account register
	            (
	                    @RequestParam String name,
	                    @RequestParam String email,
	                    @RequestParam String password
	            )
	    {
	        String passwordEnkripsi = null;

	        try
	        {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(password.getBytes());
	            byte[] bytes = md.digest();
	            StringBuilder sb = new StringBuilder();
	            for (byte aByte : bytes) {
	                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
	            }

	            passwordEnkripsi = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }

	        Account akunBaru = new Account(name, email, passwordEnkripsi, 0);

	        if(!name.isBlank())
	        {
	            if(REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()) {
	                for (Account account : getJsonTable()) {
	                    if (account.email.equals(email)) {
	                        break;
	                    }
	                    accountTable.add(account);
	                    return akunBaru;
	                }
	            }
	        }
	        return  null;
	    }

	    @PostMapping("/{id}/registerStore")
	    public Store registerStore
	            (
	                    @RequestParam int id,
	                    @RequestParam String name,
	                    @RequestParam String address,
	                    @RequestParam String phoneNumber
	            )
	    {
	        for(Account account : getJsonTable())
	        {
	            if(account.store == null && account.id == id)
	            {
	                Store store = new Store(name, address, phoneNumber, 0);
	                account.store = store;
	                return store;
	            }
	        }
	        return null;
	    }

	    @PostMapping ("/{id}/topUp")
	    public boolean topUp
	            (
	                    @RequestParam int id,
	                    @RequestParam double balance
	            )
	    {
	        for(Account account : accountTable)
	        {
	            if(account.id == id)
	            {
	                account.balance += balance;
	                return true;
	            }
	        }
	        return false;
	    }

	}