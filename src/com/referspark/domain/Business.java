package com.referspark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="business", uniqueConstraints=@UniqueConstraint(columnNames="businessid"))
@XmlRootElement(name = "business")
public class Business {
	@Id
	@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
	@Column
	Integer businessid;
	
	@Column
	String name;
		
	@ManyToOne( targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return businessid;
	}

	public void setId(int id) {
		this.businessid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
