package com.AidanAzkafaroDesonJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

/**
 * Class Store berisikan informasi dari store
 * 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */

public class Store {
	public static final String REGEX_PHONE = "^(\\d{9,12})$";
	public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
	public String name;
	public String address;
	public String phoneNumber;
	public double balance;

	/**
	 * constructor untuk kelas Store
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param balance
	 */
	public Store(String name, String address, String phoneNumber, double balance) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}

	public String toString() {
		return "name: " + (String) this.name + "\n" + "address: " + (String) this.address + "\n" + "Phone Number"
				+ (String) this.phoneNumber;
	}

	/**
	 * memvalidasi input nama dan nomor handphone ke store
	 * @return
	 */
	public boolean validate() {
		Pattern formatNum = Pattern.compile(REGEX_PHONE);
		Matcher cekPhone = formatNum.matcher(phoneNumber);
		boolean matchPhone = cekPhone.find();

		Pattern formatName = Pattern.compile(REGEX_NAME);
		Matcher cekName = formatName.matcher(name);
		boolean matchName = cekName.find();

		if (matchName == true && matchPhone == true) {
			return true;
		} else {
			return false;
		}
	}

}
