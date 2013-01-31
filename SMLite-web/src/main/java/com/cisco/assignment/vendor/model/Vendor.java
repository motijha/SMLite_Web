package com.cisco.assignment.vendor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
    
	@Column(name = "name")
	private String name;
    
	@Transient
	private boolean purchaseOrderAvailable;
	
	@Column(name = "purchaseOrderAvailable")
	private int purchaseAvailable;
    
	@Column(name = "purchaseNumber")
	private String purchaseNumber;
    
	@Column(name = "orderType")
	private int orderType;
	
	@Column(name = "cost")
	private int cost;
	
	public Vendor() {
	}

	public Vendor(int id, String name, boolean purchaseOrderAvailable,
			String purchaseNumber, int orderType, int cost) {
		this.id = id;
		this.name = name;
		this.purchaseAvailable = purchaseOrderAvailable == true ? 1 : 0;
		this.purchaseNumber = purchaseNumber;
		this.orderType = orderType;
		this.cost = cost;
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
		if(!purchaseOrderAvailable) {
			return purchaseAvailable == 1 ? true : false;
		}		
		return purchaseOrderAvailable;
	}
	public void setPurchaseOrderAvailable(boolean purchaseOrderAvailable) {
		this.purchaseAvailable = (purchaseOrderAvailable == true)  ? 1 : 0;
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
				+ ", purchaseOrderAvailable=" + purchaseOrderAvailable +", Cost=" + cost 
				+ ", purchaseNumber=" + purchaseNumber + ", purchaseType="
				+ orderType + "]";
	}

	/**
	 * @param purchaseAvailable the purchaseAvailable to set
	 */
	public void setPurchaseAvailable(int purchaseAvailable) {
		this.purchaseAvailable = (purchaseOrderAvailable == true)  ? 1 : 0;
	}

	/**
	 * @return the purchaseAvailable
	 */
	public int getPurchaseAvailable() {
		return purchaseAvailable;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
}
