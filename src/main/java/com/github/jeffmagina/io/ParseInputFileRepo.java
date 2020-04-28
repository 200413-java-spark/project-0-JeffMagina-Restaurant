package com.github.jeffmagina.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.github.jeffmagina.format.Format;
import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.customerticket.order.Order;

public class ParseInputFileRepo implements Dao<CustomerTicket> {
	private File fileName;

	public ParseInputFileRepo(File fileName) {
		this.fileName = fileName;
	}

	@Override
	public void insert(CustomerTicket e) {
	}

	@Override
	public ArrayList<CustomerTicket> readAll() {
		ArrayList<String> messages = new ArrayList<String>();

		try (FileReader in = new FileReader(fileName); BufferedReader reader = new BufferedReader(in);) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				messages.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ParseCustOrderForm(messages);
	}

	private ArrayList<CustomerTicket> ParseCustOrderForm(ArrayList<String> messages) {
		ArrayList<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();

		for (int i = 0; i < messages.size(); i++) {
			// read in raw data from file to a string
			String message = messages.get(i);

			// take raw string data parse and format
			String[] buffer = message.split(",");

			CustomerTicket customerTicket = new CustomerTicket();
			// add customer name to customer order from file - formatted
			Format format = new Format();
			customerTicket.customer.name = format.firstLettertoUpperCase(buffer[0]);

			// take customer order parse, format, and add to customer order
			String[] custOrder = buffer[1].split("/");
			for (int j = 0; j < custOrder.length; j++) {
				String[] splitCustOrder = custOrder[j].split(" ");
				int quantity = Integer.parseInt(splitCustOrder[0]);
				String name = format.firstLettertoUpperCase(splitCustOrder[1]);
				customerTicket.order.add(new Order(quantity, name));
			}

			// add customer payment amount to customer order from file
			customerTicket.paymentAmount = Double.parseDouble(buffer[2]);
			customerTickets.add(customerTicket);
		}
		return customerTickets;

	}

}
