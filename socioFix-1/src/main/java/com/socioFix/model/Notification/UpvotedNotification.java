package com.socioFix.model.Notification;

import java.io.Serializable;

import com.socioFix.model.Drive;
import com.socioFix.model.User;

import jakarta.persistence.*;


/**
 * The persistent class for the upvoted_notification database table.
 * 
 */
@Entity
@Table(name="upvoted_notification")
@DiscriminatorValue("upvoted_notification")
@PrimaryKeyJoinColumn(name="upvoted_notification_id",foreignKey=@ForeignKey(name = "fk_upvoted_notification_id"))
public class UpvotedNotification extends Notification {



	@Column(columnDefinition = "TEXT default 'Your post has been upvoted!'")
	private String description;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="by_user_id",foreignKey=@ForeignKey(name = "fk_user_id"))
	private User byUser;

	public UpvotedNotification() {
	}



	public User getByUser() {
		
		return this.byUser;
	}

	public void setByUser(User byUser) {
		this.byUser = byUser;
	}

}