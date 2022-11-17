package com.hibernate.MavenHibernate;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="studentDetails")
public class student {
	
	@GeneratedValue
	@Id
	private int id;
	
	//to give specific coloumn name
	//@Column(name="studentName")
	private String name;
	
	@Transient  //this will do hibernate will not create the column 
	private String greeting;
	
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
