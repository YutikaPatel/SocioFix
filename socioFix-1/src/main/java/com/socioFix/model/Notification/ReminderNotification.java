package com.socioFix.model.Notification;


import java.io.Serializable;

import com.socioFix.model.Drive;

import jakarta.persistence.*;


/**
 * The persistent class for the reminder_notification database table.
 * 
 */
@Entity
@Table(name="reminder_notification")
@DiscriminatorValue("reminder_notification")
@PrimaryKeyJoinColumn(name="reminder_notification_id",foreignKey=@ForeignKey(name = "fk_reminder_notification_id"))
public class ReminderNotification extends Notification {



	//bi-directional many-to-one association to Drive
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="drive_id",foreignKey=@ForeignKey(name = "fk_drive_id"))
	private Drive drive;


	@Column(columnDefinition = "TEXT default 'Reminder!'")
	private String description;
	
	public ReminderNotification() {
	}

	public Drive getDrive() {
		return this.drive;
	}

	public void setDrive(Drive drive) {
		this.drive = drive;
	}


}