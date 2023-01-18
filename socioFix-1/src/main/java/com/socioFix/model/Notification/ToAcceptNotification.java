package com.socioFix.model.Notification;

import java.io.Serializable;

import com.socioFix.model.Post;

import jakarta.persistence.*;


/**
 * The persistent class for the to_accept_notification database table.
 * 
 */
@Entity
@Table(name="to_accept_notification")
@DiscriminatorValue("to_accept_notification")
@PrimaryKeyJoinColumn(name="to_accept_notification_id",foreignKey=@ForeignKey(name = "fk_notification_id"))
public class ToAcceptNotification extends Notification {


	//bi-directional many-to-one association to Post
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;

	@Column(columnDefinition = "TEXT default 'Someone needs your help! Check request'")
	private String description;


	public ToAcceptNotification() {
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

//	public Integer getToAcceptNotificationId() {
//		return this.toAcceptNotificationId;
//	}
//
//	public void setToAcceptNotificationId(Integer toAcceptNotificationId) {
//		this.toAcceptNotificationId = toAcceptNotificationId;
//	}
//

//
	

}