package com.github.jeffmagina.takeout.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.github.jeffmagina.takeout.restaurant.customerticket.CustomerTicket;

public class HistoryOutputFileRepo implements Dao<CustomerTicket> {
	private File fileName;

	public HistoryOutputFileRepo(File fileName) {
		this.fileName = fileName;
	}

	@Override
	public void insert(CustomerTicket customerTicket) {
		// Print to file
		try (FileWriter fw = new FileWriter(this.fileName, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {

			pw.println(customerTicket.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<CustomerTicket> readAll() {
		return null;
	}
}
