package com.bbi;

import java.time.LocalDate;

public class CustomerDetails {
private String customer_name;
private String pan_number;
private String product_type;
private String manufacturer;
private String product_model;
private int product_price;
private String purchase_date;
private String Season;
private int Discount;
private double net_price;


public CustomerDetails(String customer_name, String pan_number, String product_type, int product_price, String Season,int Discount,double net_price) {
	super();
	this.customer_name = customer_name;
	this.pan_number = pan_number;
	this.product_type = product_type;
	this.product_price = product_price;
	this.Season=Season;
	this.Discount=Discount;
	this.net_price=net_price;
} 

public CustomerDetails(String customer_name, String pan_number, String product_type, String manufacturer, String product_model, int product_price, String purchase_date) {
	super();
	this.customer_name = customer_name;
	this.pan_number = pan_number;
	this.product_type = product_type;
	this.manufacturer = manufacturer;
	this.product_model = product_model;
	this.product_price = product_price;
	this.purchase_date = purchase_date;
}

@Override
public String toString() {
	return  customer_name+ ","  + pan_number + "," + product_type
			+ "," + product_price + "," + Season + "," + Discount
			+ "," + net_price ;
}



public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public String getPan_number() {
	return pan_number;
}
public void setPan_number(String pan_number) {
	this.pan_number = pan_number;
}
public String getProduct_type() {
	return product_type;
}
public void setProduct_type(String product_type) {
	this.product_type = product_type;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public String getProduct_model() {
	return product_model;
}
public void setProduct_model(String product_model) {
	this.product_model = product_model;
}
public int getProduct_price() {
	return product_price;
}
public void setProduct_price(int product_price) {
	this.product_price = product_price;
}
public String getPurchase_date() {
	return purchase_date;
}
public void setPurchase_date(String purchase_date) {
	this.purchase_date = purchase_date;
}

public String getSeason() {
	return Season;
}

public void setSeason(String season) {
	Season = season;
}

public int getDiscount() {
	return Discount;
}

public void setDiscount(int discount) {
	Discount = discount;
}

public double getNet_price() {
	return net_price;
}

public void setNet_price(int net_price) {
	this.net_price = net_price;
}


}
