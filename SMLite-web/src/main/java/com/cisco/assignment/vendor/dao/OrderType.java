package com.cisco.assignment.vendor.dao;

/**
 * Bean for storing purchase order types.
 * 
 * 
 */
public class OrderType {
	private int id;

	private String name;

	public OrderType() {
	}

	public OrderType(int id, String name) {
		this.id = id;
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