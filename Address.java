package com.hibernate.MavenHibernate;

import java.util.Arrays;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


//make sure to map the class in config xml file
//hibernate will create the table with this name
@Table(name="studentAddress")
@Entity
public class Address {
	
	//Primary key for table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //it will automatically create the value
	@Column(name="address_Id")  //if we want to give specif name for column
	private int addressId;
	
	//here we have define the length of the column in table
	@Column(length = 50)
	private String street;
	
	@Column(length = 50)
	private String city;
	
	private boolean isOpen;
	
	//hibernate will not create the column for this
	@Transient
	private double x;
	
	@Column(name = "add_Date")
	@Temporal(TemporalType.DATE)		//this will pick only date not time
	private Date addedDate;
	
	@Lob				//For large data we use this
	private byte[] image;
	
	//general Constructor
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parametrised constructor
	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}
	
	
	//toString method
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen
				+ ", x=" + x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
}
