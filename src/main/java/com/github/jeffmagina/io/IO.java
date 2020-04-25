package com.github.jeffmagina.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.github.jeffmagina.format.Format;
import com.github.jeffmagina.restaurant.customer.Customer;
import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.customerticket.order.Order;
import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;

public class IO {

	OrderHistory orderHistory = new OrderHistory();

	public class FileParser {

	}

	public void write(File fileName, CustomerTicket customerTicket) {
		// Print to file
		try (FileWriter fw = new FileWriter(fileName, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {

			pw.println(customerTicket.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads whole file all lines
	public void read(File fileName, CustomerTicket customerTicket) {
		// Read from file
		try (FileReader in = new FileReader(fileName); BufferedReader br = new BufferedReader(in);) {
			String line = br.readLine();
			while (line != null) {
				orderHistory.storeOrder(ParseCustHistory(line));
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads file one line
	public String readFile(File fileName) {
		String message = "";

		try (FileReader in = new FileReader(fileName); BufferedReader reader = new BufferedReader(in);) {

			String line = "";
			while ((line = reader.readLine()) != null) {
				message = line;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	public CustomerTicket ParseCustOrderForm(String message) {

		// read in raw data from file to a string
		Format format = new Format();

		// take raw string data parse and format
		ArrayList<String> buffer = new ArrayList<String>();
		buffer = format.splitTokens(message, ",");
		format.wholeArrayListFirstLetterToUpperCase(buffer);

		CustomerTicket customerTicket = new CustomerTicket();
		
		// add customer name to customer order from file
		Customer customer = new Customer();
		customer.name = buffer.get(0);
		customerTicket.customer = customer;

		customerTicket.order = new ArrayList<Order>();
		// add customer order to string to parse
		String order = buffer.get(1);

		// take customer order parse, format, and add to customer order
		ArrayList<String> custOrder = new ArrayList<>();
		custOrder = format.splitTokens(order, "/");

		ArrayList<String> splitCustOrder = new ArrayList<>();

		for (int i = 0; i < custOrder.size(); i++) {
			Order testOrder = new Order();
			splitCustOrder = format.splitTokens(custOrder.get(i), " ");

			testOrder.quantity = Integer.parseInt(splitCustOrder.get(0));
			testOrder.name = format.firstLettertoUpperCase(splitCustOrder.get(1));
			customerTicket.order.add(testOrder);

		}

		// add customer payment amount to customer order from file
		customerTicket.paymentAmount = Double.parseDouble(buffer.get(2));

		return customerTicket;

	}

	public CustomerTicket ParseCustHistory(String message) {

		Format format = new Format();
		ArrayList<String> buffer = new ArrayList<String>();
		buffer = format.splitTokens(message, ",");

		// add customer id and name to customerTicket from history file
		CustomerTicket customerTicket = new CustomerTicket();
		Customer customer = new Customer();
		customer.customerId = Integer.parseInt(buffer.get(0));
		customer.name = buffer.get(1);
		customerTicket.customer = customer;
		
		// add customer order to customerTicket from history file
		customerTicket.order = new ArrayList<Order>();
		String rawOrder = buffer.get(2);
		
		//parse customer order into array list
		ArrayList<String> listRawOrder = new ArrayList<String>();
		listRawOrder = format.splitTokens(rawOrder, "&");
		
		//store into quantity and name fields
		ArrayList<String> splitCustOrder = new ArrayList<String>();
		
		for(int i = 0; i < listRawOrder.size(); i++) {
			Order order = new Order();
			splitCustOrder = format.splitTokens(listRawOrder.get(i), " ");
			
			order.quantity = Integer.parseInt(splitCustOrder.get(0));
			order.name = splitCustOrder.get(1);
			customerTicket.order.add(order);
		}
		
		// add order cost to CustomerTicket from history File
		customerTicket.orderCost = Double.parseDouble(buffer.get(3));
		
		// add customer payment to CustomerTicket from history File
		customerTicket.paymentAmount = Double.parseDouble(buffer.get(4));

		// add change given to CustomerTicket from history File
		customerTicket.changeGiven = Double.parseDouble(buffer.get(5));
		
		return customerTicket;
	}

}
