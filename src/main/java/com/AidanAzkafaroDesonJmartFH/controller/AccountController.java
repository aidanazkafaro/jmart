package com.AidanAzkafaroDesonJmartFH.controller;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.Store;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

/**
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
	
	//instance variable regex
	public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{7,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	@JsonAutowired(value = Account.class, filepath = "Akun.json")
	public static JsonTable<Account> accountTable;

	/**
	 * mengecek data email dan password ke accountTable untuk LOGIN
	 * @param email 
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	Account login(@RequestParam String email, @RequestParam String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for (Account data : accountTable) {

			if (data.email.equals(email) && data.password.equals(password)) {
				return data;
			}
		}
		return null;
	}

	/**
	 * memasukkan data name, email, password ke accountTable untuk REGISTER
	 * @param name
	 * @param email
	 * @param password
	 * @return
	 */
	@PostMapping("/register")
	Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

		boolean hasilEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
		boolean hasilPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (!name.isBlank() && hasilEmail && hasilPassword
				&& !accountTable.stream().anyMatch(account -> account.email.equals(email))) {
			Account account = new Account(name, email, password, 0);
			accountTable.add(account);
			return account;
		}
		return null;
	}

	/**
	 * Menambahkan store
	 * @param id
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @return
	 */
	@PostMapping("/{id}/registerStore")
	Store register(@RequestParam int id, @RequestParam String name, @RequestParam String address,
			@RequestParam String phoneNumber) {
		for (Account data : accountTable) {
			if (data.store == null && data.id == id) {
				data.store = new Store(name, address, phoneNumber, 0);
				return data.store;
			}
		}
		return null;
	}

	/**
	 * melakukan top up
	 * @param id
	 * @param balance
	 * @return
	 */
	@PostMapping("/{id}/topUp")
	Boolean topUp(@RequestParam int id, @RequestParam double balance) {
		for (Account data : accountTable) {
			if (data.id == id) {
				data.balance += balance;
				return true;
			}
		}
		return false;
	}

	
	@Override
	@GetMapping("/{id}")
	public Account getById(@PathVariable int id) {
		return BasicGetController.super.getById(id);
	}

	@Override
	public JsonTable getJsonTable() {
		return accountTable;
	}

	@Override
	public List getPage(int page, int pageSize) {
		return BasicGetController.super.getPage(page, pageSize);
	}
}