package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

//@Table(name="UserCircle")
@Component
@Entity
public class UserCircle 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userCircleId;
	
	@NotNull
	private String emailId;
	@NotNull
	private int circleId;
	@NotNull
	private Date subscriptionDate;
	
	@NotNull
	private char subscriptionStatus;
	
	
	public int getUserCircleId() {
		return userCircleId;
	}
	public void setUserCircleId(int userCircleId) {
		this.userCircleId = userCircleId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate() {
		this.subscriptionDate = new Date();
	}
	public char getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(char subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	@Override
	public String toString() {
		return "UserCircle [userCircleId=" + userCircleId + ", emailId=" + emailId + ", circleId=" + circleId
				+ ", subscriptionDate=" + subscriptionDate + ", subscriptionStatus=" + subscriptionStatus + "]";
	}
	
	
	

}
