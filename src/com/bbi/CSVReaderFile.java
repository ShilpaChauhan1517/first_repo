package com.bbi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File CsvFileOutput=new File("C:\\Users\\Shilpa Chauhan\\desktop\\output.csv");
		PrintWriter out=new PrintWriter(CsvFileOutput);
		List<CustomerDetails> dataSet1=getCustomerDetails("C:\\Users\\Shilpa Chauhan\\Desktop\\dataset1.csv");
		for(CustomerDetails customerDetails:dataSet1) {
			out.println(customerDetails);
		}
		List<CustomerDetails> dataSet2=getCustomerDetails("C:\\Users\\Shilpa Chauhan\\Desktop\\dataset2.csv");
		for(CustomerDetails customerDetails:dataSet2) {
			out.println(customerDetails);
		}
		List<CustomerDetails> dataSet3=getCustomerDetails("C:\\Users\\Shilpa Chauhan\\Desktop\\dataset3.csv");
		for(CustomerDetails customerDetails:dataSet3) {
			out.println(customerDetails);
		}
		out.close();
	}

	private static List<CustomerDetails> getCustomerDetails(String file) {
	
		List<CustomerDetails> customerList = new ArrayList<>();
		Path pathToFile=Paths.get(file);
		try (BufferedReader br=Files.newBufferedReader(pathToFile)){
			String row=br.readLine();
			while(row!=null) {
				String [] attributes =row.split(",");
				CustomerDetails cd=getCustomer(attributes);
				customerList.add(cd);
				row=br.readLine();
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return customerList;
	}

	//Preprocessing  input  --code 
	
	private static CustomerDetails getCustomer(String[] attributes) {
		String customer_name;
		int product_price ;
		String pan_number="";
		String Season = null;
		int Discount=0;
		double net_price=0;
	
		if(attributes[0]=="") {
			customer_name="abc xyz";
		}else {
		customer_name=attributes[0];
		}

		String str="";
		String res="";
		if(attributes[1]=="") {
			
		pan_number="AAAAAXXXXX";
		}
		else if(attributes[1].contains("-")){
			
			pan_number=attributes[1].replace("-","");
		}
		
		else if(attributes[1].contains(".")) {
		res=attributes[1].substring(0,attributes[1].indexOf("."));
			pan_number=res;
		}
		
		else {
			pan_number=attributes[1];
		}

		String product_type = attributes[2];
		String manufacturer =attributes[3];
		String product_model =attributes[4];
		
		if(attributes[5]=="") {
		product_price = 0;
		}
		
		else if(Integer.parseInt(attributes[5]) < 0){
			product_price =Math.abs(Integer.parseInt(attributes[5]));
		}
		
		else {
			product_price=Integer.parseInt(attributes[5]);
		}
		
		//Output CSV code
		
		String purchase_date =attributes[6];
		double Discount_price=0;

		LocalDate date=LocalDate.parse(purchase_date);
		if(product_type.equals("TV")) 
		{
		if(date.getMonth() == Month.DECEMBER || date.getMonth() == Month.JANUARY) {
			Season="New Year";
			Discount=4;
			Discount_price=((product_price*Discount)/100);
			net_price=(product_price-Discount_price);
			
		}else if(date.getMonth()==Month.JUNE || date.getMonth()==Month.JULY) {
			Season="Special";
			Discount=6;
			Discount_price=((product_price*Discount)/100);
			net_price=(product_price-Discount_price);
		}else if(date.getMonth() == Month.SEPTEMBER || date.getMonth() == Month.OCTOBER || date.getMonth() == Month.NOVEMBER ) {
			Season="Festive";
			Discount=5;
			Discount_price=((product_price*Discount)/100);
			net_price=(product_price-Discount_price);
		}else {
			Season="Normal";
			net_price=product_price;
		}
		}else if(product_type.equals("Laptop")) {
			if(date.getMonth() == Month.DECEMBER || date.getMonth() == Month.JANUARY) {
				Season="New Year";
				Discount=10;
				Discount_price=((product_price*Discount)/100);
				net_price=(product_price-Discount_price);
			}else if(date.getMonth() == Month.JUNE || date.getMonth()== Month.JULY) {
				Season="Special";
				Discount=12;
				Discount_price=((product_price*Discount)/100);
				net_price=(product_price-Discount_price);
			}else if(date.getMonth() == Month.SEPTEMBER || date.getMonth() ==Month.OCTOBER || date.getMonth() == Month.NOVEMBER ) {
				Season="Festive";
				Discount=15;
				Discount_price=((product_price*Discount)/100);
				net_price=(product_price-Discount_price);
			}else {
				Season="Normal";
				net_price=product_price;
			}
			}else if(product_type.equals("Tablet")) {
				if(date.getMonth() == Month.DECEMBER || date.getMonth() == Month.JANUARY) {
					Season="New Year";
					Discount=8;
					Discount_price=((product_price*Discount)/100);
					net_price=(product_price-Discount_price);
				}else if(date.getMonth()== Month.JUNE || date.getMonth()== Month.JULY) {
					Season="Special";
					Discount=12;
					Discount_price=((product_price*Discount)/100);
					net_price=(product_price-Discount_price);
				}else if(date.getMonth() == Month.SEPTEMBER || date.getMonth() == Month.OCTOBER || date.getMonth() == Month.NOVEMBER ) {
					Season="Festive";
					Discount=15;
					Discount_price=((product_price*Discount)/100);
					net_price=(product_price-Discount_price);
				}else {
					Season="Normal";
					net_price=product_price;
				}
				
				}else if(product_type.equals("Mobile")) {
					if(date.getMonth() == Month.DECEMBER || date.getMonth() == Month.JANUARY) {
						Season="New Year";
						Discount=7;
						Discount_price=((product_price*Discount)/100);
						net_price=(product_price-Discount_price);
					}else if(date.getMonth() == Month.JUNE || date.getMonth()==Month.JULY) {
						Season="Special";
						Discount=5;
						Discount_price=((product_price*Discount)/100);
						net_price=(product_price-Discount_price);
					}else if(date.getMonth() == Month.SEPTEMBER || date.getMonth()== Month.OCTOBER || date.getMonth() == Month.NOVEMBER ) {
						Season="Festive";
						Discount=6;
						Discount_price=((product_price*Discount)/100);
						net_price=(product_price-Discount_price);
					}else {
						Season="Normal";
						net_price=product_price;
					}
					}
	
		CustomerDetails customerDetail=new CustomerDetails(customer_name,pan_number,product_type,product_price, Season , Discount,net_price);
		return customerDetail;
		
	}
}