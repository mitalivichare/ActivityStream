package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="UserCircle")
public class UserCircle 
{
	@Id
	private int userCircleId;
	
	//emialId should be unqie and not null
	@NotNull
	private String emailId;
	@NotNull
	private int circleId;
	@NotNull
	private Date subscriptionDate;
	
	
	//All the status fields can be char data type. like s->subscribed, u->unscribed etc.,
	//Note use char for all fields where you are storing status.
	@NotNull
	private String subscriptionStatus;
	
	
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
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	@Override
	public String toString() {
		return "UserCircle [userCircleId=" + userCircleId + ", emailId=" + emailId + ", circleId=" + circleId
				+ ", subscriptionDate=" + subscriptionDate + ", subscriptionStatus=" + subscriptionStatus + "]";
	}
	
	
	

}
