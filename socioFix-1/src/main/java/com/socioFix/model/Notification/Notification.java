package com.socioFix.model.Notification;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;

import com.socioFix.model.Post;
import com.socioFix.model.User;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "notification_type")
public class Notification  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notification_id")
	private Integer notificationId;

	@Column(name="created_at")
	private Timestamp createdAt;



	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User toUser;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id",foreignKey=@ForeignKey(name = "fk_post_id"))
	private Post post;



	public Notification() {
	}

	public Integer getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

//	public AcceptedNotification getAcceptedNotification() {
//		return this.acceptedNotification;
//	}
//
//	public void setAcceptedNotification(AcceptedNotification acceptedNotification) {
//		this.acceptedNotification = acceptedNotification;
//	}
//
//	public ContributeNotification getContributeNotification() {
//		return this.contributeNotification;
//	}
//
//	public void setContributeNotification(ContributeNotification contributeNotification) {
//		this.contributeNotification = contributeNotification;
//	}
//
	public User getToUser() {
		return this.toUser;
	}

	public void setToUser(User user) {
		this.toUser = user;
	}

//	public ReminderNotification getReminderNotification() {
//		return this.reminderNotification;
//	}
//
//	public void setReminderNotification(ReminderNotification reminderNotification) {
//		this.reminderNotification = reminderNotification;
//	}
//
//	public StatusNotification getStatusNotification() {
//		return this.statusNotification;
//	}
//
//	public void setStatusNotification(StatusNotification statusNotification) {
//		this.statusNotification = statusNotification;
//	}
//
//	public ToAcceptNotification getToAcceptNotification() {
//		return this.toAcceptNotification;
//	}
//
//	public void setToAcceptNotification(ToAcceptNotification toAcceptNotification) {
//		this.toAcceptNotification = toAcceptNotification;
//	}
//
//	public UpvotedNotification getUpvotedNotification() {
//		return this.upvotedNotification;
//	}
//
//	public void setUpvotedNotification(UpvotedNotification upvotedNotification) {
//		this.upvotedNotification = upvotedNotification;
//	}
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}