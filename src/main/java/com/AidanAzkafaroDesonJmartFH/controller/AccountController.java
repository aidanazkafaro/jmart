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

	@GetMapping("/page")
	public List<Account> getPage(int page, int pageSize) {
		return getJsonTable().subList(page, pageSize);
	}

	@Override
	public JsonTable<Account> getJsonTable() {
		// TODO Auto-generated method stub
		return accountTable;
	}

	@PostMapping("/login")
	public Account login(@RequestParam String email, @RequestParam String password) {
		String generatedPassword = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(password.getBytes());

			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Account account : getJsonTable()) {
			if (account.email.equals(email) && account.password.equals(generatedPassword)) {
				return account;
			}
		}
		return null;
	}

	@PostMapping("/register")
	public Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

		String generatedPassword = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(password.getBytes());

			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Account newAccount = new Account(name, email, generatedPassword, 0.0);
		if ((!name.isBlank())) {
			if (REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(generatedPassword).matches()) {
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
	public Store registerStore(@RequestParam int id, @RequestParam String name, @RequestParam String address,
			@RequestParam String phoneNumber) {
		for (Account account : getJsonTable()) {
			if (account.id == id && account.store == null) {
				Store store = new Store(name, address, phoneNumber, 0.0);
				account.store = store;
				return store;
			}
		}
		return null;

	}

	@PostMapping("/{id}/topUp")
	boolean topUp(@RequestParam int id, @RequestParam double balance) {
		for (Account each : accountTable) {
			if (each.id == id) {
				each.balance += balance;
				return true;
			}
		}
		return false;
	}

	@GetMapping("/{id}")
	public Account getById(int id) {
		return getJsonTable().get(id);
	}

}