package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Circle 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int circleId;
	
	@NotNull
	@Column
	private String circleName;
	
	@NotNull
	@Column
	private String circleOwner;
	
	@Column
	private String circleDescription;
	
	@NotNull
	@Column
	private Date circleCreationDate;
	
	@NotNull
	@Column
	private String circleStatus;
	
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public String getCircleOwner() {
		return circleOwner;
	}
	public void setCircleOwner(String circleOwner) {
		this.circleOwner = circleOwner;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public String getCircleDescription() {
		return circleDescription;
	}
	public void setCircleDescription(String circleDescription) {
		this.circleDescription = circleDescription;
	}
	public Date getCircleCreationDate() {
		return circleCreationDate;
	}
	public void setCircleCreationDate() {
		this.circleCreationDate = new Date();
	}
	
	public String getCircleStatus() {
		return circleStatus;
	}
	public void setCircleStatus(String circleStatus) {
		this.circleStatus = circleStatus;
	}
	@Override
	public String toString() {
		return "Circle [circleId=" + circleId + ", circleName=" + circleName + ", circleOwner=" + circleOwner
				+ ", circleDescription=" + circleDescription + ", circleCreationDate=" + circleCreationDate
				+ ", circleStatus=" + circleStatus + "]";
	}
	
	

}
