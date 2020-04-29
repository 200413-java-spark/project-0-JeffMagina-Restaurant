package com.github.jeffmagina.takeout.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.github.jeffmagina.takeout.format.Format;
import com.github.jeffmagina.takeout.restaurant.customerticket.CustomerTicket;

public class ParseInputFileRepo implements Dao<CustomerTicket> {
	private File fileName;

	public ParseInputFileRepo(File fileName) {
		this.fileName = fileName;
	}

	@Override
	public void insert(CustomerTicket customerTicket) {
	}

	@Override
	public ArrayList<CustomerTicket> readAll() {
		ArrayList<String> messages = new ArrayList<String>();
		Format format = new Format();

		try (FileReader in = new FileReader(this.fileName); BufferedReader reader = new BufferedReader(in);) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				messages.add(line);
			}
			reader.close();
		} catch (FileNotFoundException ex) {
			System.err.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return format.ParseCustOrderForms(messages);
	}


}
