package com.stackroute.activitystream.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component //to tell spring 	about bean creation
@Entity //to tell hibernate about the table creation
public class User 
{

	//@Column(name="EMAIL_ID")
	@Id
	@Column
	private String emailId;
	
	
	//@Column(name="FIRST_NAME")
	//@JsonProperty(value="first_name")
	@NotNull
	@Column
	private String firstName;
	
	
	//@Column(name="LAST_NAME")
	//@JsonProperty(value="last_name")
	@NotNull
	@Column
	private String lastName;
	
	//@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	
	
	//@Column(name="PASSWORD")
	@NotNull
	@Column
	private String password;
	
	//@Column(name="CONTACT_NUMBER")
	//@Pattern(regexp="^\\d(10)")
	//@JsonProperty(value="contact_number")
	@Column
	private String contactNumber;
	
	
	//@Column(name="USER_STATUS")
	//@JsonProperty(value="user_status")
	@NotNull
	@Column
	private char userStatus;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public char getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(char userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password="
				+ password + ", contactNumber=" + contactNumber + ", userStatus=" + userStatus + "]";
	}
	
	
	
	
}
