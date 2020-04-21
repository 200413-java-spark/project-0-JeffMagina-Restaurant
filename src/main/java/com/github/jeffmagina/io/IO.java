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
import java.util.List;

import com.github.jeffmagina.format.Format;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class IO {

	public class FileParser {

	}

	public void write(File fileName, CustomerOrder custOrder) {
		// Print to file
		try (FileWriter fw = new FileWriter(fileName, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {

			pw.println(custOrder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads whole file all lines
	public void read(File fileName, CustomerOrder customerOrder, List<CustomerOrder> custOrders) {
		// Read from file
		try (FileReader in = new FileReader(fileName); 
				BufferedReader br = new BufferedReader(in);) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				custOrders.add(customerOrder);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads file one line
	private String readFile(File fileName) {
		// ArrayList<String> message = new ArrayList<>();
		String message = "";

		try (FileReader in = new FileReader(fileName); 
				BufferedReader reader = new BufferedReader(in);) {

			String line = "";
			while ((line = reader.readLine()) != null) {
				// message.add(line);
				message = line;
			}
			reader.close();
			// return line;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	public CustomerOrder ParseCustOrderForm(File fileName) {

		// read in raw data from file to a string
		String message = readFile(fileName);
		Format format = new Format();

		// take raw string data parse and format
		ArrayList<String> customerTicket = new ArrayList<String>();
		customerTicket = format.splitTokens(message,",");
		format.firstLettertoUpperCase(customerTicket);

		CustomerOrder customerOrder = new CustomerOrder();
		
		// add customer name to customer order from file
		customerOrder.name = customerTicket.get(0);

		// add customer order to string to parse
		String order = customerTicket.get(1);
		
		//take customer order parse, format, and add to customer order
		ArrayList<String> custOrder = new ArrayList<>();
		custOrder = format.splitTokens(order," ");
		format.firstLettertoUpperCase(custOrder);
		customerOrder.order = custOrder;

		// add customer payment amount to customer order from file
		customerOrder.paymentAmount = Double.parseDouble(customerTicket.get(2));
		
		return customerOrder;

	}
}
