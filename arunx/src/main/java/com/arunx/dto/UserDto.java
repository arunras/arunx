package com.arunx.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	private String martchingPassword;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getMartchingPassword() {
		return martchingPassword;
	}
	public void setMartchingPassword(String martchingPassword) {
		this.martchingPassword = martchingPassword;
	}
	
	
}
