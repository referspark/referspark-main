package com.referspark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames="userid"))
@XmlRootElement(name = "user")
public class User {
	@Id
	@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
	@Column
	Integer userid;
	
	@Column
	String firstname;

	@Column
	String lastname;
	
	@Column
	String email;
	
	@Column
	String mobile;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	

}
