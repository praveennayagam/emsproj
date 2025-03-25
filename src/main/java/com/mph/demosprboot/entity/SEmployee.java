package com.mph.demosprboot.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class SEmployee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long eid;
	private String ename;
	private String email;
	private String password;
	private String gender;
	private boolean isMarried;
//	@ElementCollection
//	private List<String> phno;
//	@JsonFormat(pattern ="yyyy-mm-dd")
//	private Date dob;
	public boolean getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
//	public List<String> getPhno() {
//		return phno;
//	}
//	public void setPhno(List<String> phno) {
//		this.phno = phno;
//	}
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
	public long getEid() {
		return eid;
	}
	public void setEid(long eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "SEmployee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", isMarried=" + isMarried + "]";
	}
	
	
}
