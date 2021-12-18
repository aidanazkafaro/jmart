package com.AidanAzkafaroDesonJmartFH;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

/**
 * Class Complaint dipakai untuk membuat dan mengembalikan complaint saat barang sudah diterima
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class Complaint extends Serializable {
	// instance variables - replace the example below with your own
	public String desc;
	public final Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructor pembuatan complaint
     * @param desc
     */
	public Complaint(String desc) {
		this.desc = desc;
		this.date = new Date();
	}

	/**
     * toString method untuk menampilkan data complaint dalam bentuk String
     */
	public String toString() {
		String formatDate = sdf.format(date);
		return "Complaint{date = " + formatDate + ", desc = '" + desc + "'}";
	}

}
