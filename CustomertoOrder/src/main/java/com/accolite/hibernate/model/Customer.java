package com.accolite.hibernate.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	
	
	private Long custId;
	
	private String custName;
	
	private String custType;
	
	
	private Set<Order> orders = new HashSet<Order>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custName, String custType) {
		super();
		this.custName = custName;
		this.custType = custType;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUSTID")
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}
                    

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders() {
		return this.orders;
	}



	public void setAccounts(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Customer [custId=" + custId + ", custName=" + custName + ", custType=" + custType + ", orders="
				+ (orders != null ? toString(orders, maxLen) : null) + "]";
	}
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
