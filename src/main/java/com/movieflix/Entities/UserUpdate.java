package com.movieflix.Entities;

public class UserUpdate {
	String name;
	String email;
	long phone;
	String address;
	public UserUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdate(String name, String email, long phone, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "UserUpdate [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
