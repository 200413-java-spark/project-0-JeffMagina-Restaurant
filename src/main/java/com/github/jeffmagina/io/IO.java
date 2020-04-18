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
import java.util.StringTokenizer;

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
		try (FileReader in = new FileReader(fileName); BufferedReader br = new BufferedReader(in);) {
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
	private ArrayList<String> readFile(File fileName) throws IOException {
		ArrayList<String> message = new ArrayList<>();
		
		try (FileReader in = new FileReader(fileName); 
				BufferedReader reader = new BufferedReader(in);) {

			String line ="";
			while ((line = reader.readLine()) != null) {
				message.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	public CustomerOrder ParseCustOrderForm(File fileName) throws IOException {

		ArrayList<String> message = new ArrayList<>();
		message = readFile(fileName);

		CustomerOrder customerOrder = new CustomerOrder();

		// add customer name to customer order from file
		customerOrder.name = message.get(0);

		// add customer order to customer order from file
		String order = message.get(1);
		StringTokenizer orderToken = new StringTokenizer(order, " ");
		ArrayList<String> custOrder = new ArrayList<>();
		while (orderToken.hasMoreTokens()) {
			custOrder.add(orderToken.nextToken().toLowerCase());
		}
		customerOrder.order = custOrder;

		// add customer payment amount to customer order from file
		customerOrder.paymentAmount = Double.parseDouble(message.get(2));
		return customerOrder;

	}

}
