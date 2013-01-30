package com.cisco.assignment.vendor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean for storing purchase order types.
 * 
 * 
 */
@Entity
@Table (name = "order_type")
public class OrderType {
	@Id	
	@Column(name = "id", unique = true, nullable = false)
	private int id;
    
	@Column(name = "name")
	private String name;

	public OrderType() {
	}

	public OrderType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public OrderType(String name) {		
		this.name = name;
	}

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
}