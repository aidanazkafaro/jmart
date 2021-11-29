package com.AidanAzkafaroDesonJmartFH;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable {
	// instance variables - replace the example below with your own
	public String desc;
	public final Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Complaint(String desc) {
		this.desc = desc;
		this.date = new Date();
	}

	public String toString() {
		String formatDate = sdf.format(date);
		return "Complaint{date = " + formatDate + ", desc = '" + desc + "'}";
	}

}
