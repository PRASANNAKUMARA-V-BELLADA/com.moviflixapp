package com.movieflix.Entities;

public class ForgotPassword {
    String email;
    String password;
    String password1;
    String password2;
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForgotPassword(String email, String password, String password1, String password2) {
		super();
		this.email = email;
		this.password = password;
		this.password1 = password1;
		this.password2 = password2;
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
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	@Override
	public String toString() {
		return "ForgotPassword [email=" + email + ", password=" + password + ", password1=" + password1 + ", password2="
				+ password2 + "]";
	}
    
    
}
