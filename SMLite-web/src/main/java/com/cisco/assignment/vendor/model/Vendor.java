package com.cisco.assignment.vendor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.sakaiproject.entitybus.entityprovider.annotations.EntityId;

/**
 * Bean to store the vendor details.
 * 
 * 
 */
@Entity
@Table (name = "vendor")
public class Vendor {

	@EntityId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
    
	@Column(name = "name")
	private String name;
    
	@Column(name = "purchaseOrderAvailable")
	private int purchaseOrderAvailable;
    
	@Column(name = "purchaseNumber")
	private String purchaseNumber;
    
	@Column(name = "orderType")
	private int orderType;

	public Vendor() {
	}

	public Vendor(int id, String name, int purchaseOrderAvailable,
			String purchaseNumber, int orderType) {
		this.id = id;
		this.name = name;
		this.purchaseOrderAvailable = purchaseOrderAvailable;
		this.purchaseNumber = purchaseNumber;
		this.orderType = orderType;
	}
    
	
	public Vendor(String name, int purchaseOrderAvailable,
			String purchaseNumber, int orderType) {
		this.name = name;
		this.purchaseOrderAvailable = purchaseOrderAvailable;
		this.purchaseNumber = purchaseNumber;
		this.orderType = orderType;
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

	public boolean isPurchaseOrderAvailable() {	    
		return purchaseOrderAvailable == 1 ? true : false;
	}

	public void setPurchaseOrderAvailable(int purchaseOrderAvailable) {
		this.purchaseOrderAvailable = purchaseOrderAvailable;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String toString() {
		return "Vendor [id=" + id + ", name=" + name
				+ ", purchaseOrderAvailable=" + purchaseOrderAvailable
				+ ", purchaseNumber=" + purchaseNumber + ", purchaseType="
				+ orderType + "]";
	}
}
