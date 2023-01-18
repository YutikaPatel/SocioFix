package com.socioFix.model.Notification;

import java.io.Serializable;

import com.socioFix.model.User;

import jakarta.persistence.*;


/**
 * The persistent class for the contribute_notification database table.
 * 
 */
@Entity
@Table(name="contribute_notification")
@DiscriminatorValue("contribute_notification")
@PrimaryKeyJoinColumn(name="contribute_notification_id",foreignKey=@ForeignKey(name = "fk_contribute_notification_id"))
public class ContributeNotification extends Notification{


	@Column(name="contact_no")
	private String contactNo;


	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="from_user_id",foreignKey=@ForeignKey(name = "fk_user_id"))
	private User fromUser;

	@Column(columnDefinition = "TEXT default 'You have been offered help! Check the request'")
	private String description;


	
	public ContributeNotification() {
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Integer getContributeNotificationId() {
//		return this.contributeNotificationId;
//	}
//
//	public void setContributeNotificationId(Integer contributeNotificationId) {
//		this.contributeNotificationId = contributeNotificationId;
//	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public User getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

}