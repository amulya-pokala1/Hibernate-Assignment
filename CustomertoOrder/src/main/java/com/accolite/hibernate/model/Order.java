package com.accolite.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.accolite.hibernate.model.Customer;

@Entity
@Table(name="ORDER")
public class Order {
	
	public Order(String orderName) {
		super();
		
		this.orderName = orderName;
	}

	private Long orderNo;
	private Customer customer;
	private String orderName;
	public Order()
	{
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderName() {
		return orderName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderName == null) ? 0 : orderName.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderName == null) {
			if (other.orderName != null)
				return false;
		} else if (!orderName.equals(other.orderName))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		return true;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CUSTID", nullable=false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", orderName=" + orderName + ", customer=" + customer + "]";
	}
	

}
