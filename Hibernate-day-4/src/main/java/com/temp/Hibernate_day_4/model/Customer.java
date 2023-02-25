package com.temp.Hibernate_day_4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="custdet4")
public class Customer {

	
@Id
@GeneratedValue
private int id;


@Column
private String cname,cadd;

public Customer(int id, String cname, String cadd) {
	super();
	this.id = id;
	this.cname = cname;
	this.cadd = cadd;
}


@Override
public String toString() {
	return "Customer [id=" + id + ", cname=" + cname + ", cadd=" + cadd + "]";
}


public Customer(String cname, String cadd) {
	super();
	this.cname = cname;
	this.cadd = cadd;
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCadd() {
	return cadd;
}
public void setCadd(String cadd) {
	this.cadd = cadd;
}




}
