package com.referspark.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="business", uniqueConstraints=@UniqueConstraint(columnNames={"businessid"}))
@XmlRootElement(name = "business")
public class Business {
	@Id
	//@GenericGenerator(name="generator", strategy="increment")
    //@GeneratedValue(generator="generator")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer businessid;
	
	@Column
	private String businessname;
		
	@ManyToOne( targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@Column
	private String password;
	
	@Column
	private String city;
	
	@Column
	private String industry;
	
	@Column
	private Date onboarddate;
	
	@Column
	private Integer hasfullinfo;
	
	@Column
	private Date fullinfoenterdate;
	
	public Date getFullinfoenterdate() {
		return fullinfoenterdate;
	}

	public void setFullinfoenterdate(Date fullinfoenterdate) {
		this.fullinfoenterdate = fullinfoenterdate;
	}

	public Integer getHasfullinfo() {
		return hasfullinfo;
	}

	public void setHasfullinfo(Integer hasfullinfo) {
		this.hasfullinfo = hasfullinfo;
	}

	public Integer getBusinessid() {
		return businessid;
	}

	public void setBusinessid(Integer businessid) {
		this.businessid = businessid;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Date getOnboarddate() {
		return onboarddate;
	}

	public void setOnboarddate(Date onboarddate) {
		this.onboarddate = onboarddate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
