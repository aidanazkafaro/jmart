package com.AidanAzkafaroDesonJmartFH.controller;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.JsonTable;
import com.AidanAzkafaroDesonJmartFH.Store;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
	public static final String REGEX_EMAIL = "^\\\\w+([.&`~-]?\\\\w+)*@\\\\w+([.-]?\\\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d][^-\\\\s]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

	@JsonAutowired(filepath = "C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\jsonFiles\\randomProductList.json", value = Account.class)
	public static JsonTable<Account> accountTable;

	@GetMapping("/account")
	String index() {
		return "account page";
	}

//	@PostMapping("/register")
//	Account register
//	(
//		@RequestParam String name,
//		@RequestParam String email,
//		@RequestParam String password
//	)
//	{
//		return new Account(name, email, password, 0);
//	}

//	@GetMapping("/account/{id}")
//	String getById(@PathVariable int id) { return "account id " + id + " not found!"; }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
    
	@Override
	@GetMapping("/account")
	public JsonTable<Account> getJsonTable() {
		// TODO Auto-generated method stub
		return accountTable;
	}

	@PostMapping("/login")
	public Account login( @RequestParam String email, @RequestParam String password) {
		for (Account account : getJsonTable()) {
			if (account.email.equals(email) && account.password.equals(password)) {
				return account;
			}
		}
		return null;
	}

	@PostMapping("/register")
	public Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		Account newAccount = new Account(name, email, password, 0.0);
		if ((!name.isBlank())) {
			if (REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()) {
				for (Account account : getJsonTable()) {
					if (account.email.equals(email)) {
						break;
					}
					accountTable.add(account);
					return newAccount;

				}
			}
		}
		return null;
	}
	@PostMapping("/{id}/registerStore")
	public Store registerStore (@RequestParam int id, @RequestParam String name,@RequestParam  String address, @RequestParam String phoneNumber) {
		for (Account account : getJsonTable()) {
			if (account.id == id && account.store == null) {
				Store store = new Store (name, address, phoneNumber, 0.0);
				account.store = store;
				return store;
			}
		}
		return null;
		
	}
	
	@PostMapping("/{id}/topUp")
	public boolean topUp (@RequestParam int id, @RequestParam double balance) {
		return false;
		
	}

}