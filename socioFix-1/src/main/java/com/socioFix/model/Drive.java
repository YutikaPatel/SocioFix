package com.socioFix.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import com.socioFix.model.Notification.ReminderNotification;


/**
 * The persistent class for the drive database table.
 * 
 */
@Entity
public class Drive {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="drive_id")
	private Integer driveId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	private Time duration;

	@Column(name="image_path")
	private String imagePath;

	private Time time;

	private Integer upvotes;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="location_id",foreignKey = @ForeignKey(name = "fk_location_id"))
	private Location location;

	//bi-directional many-to-one association to Organization
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organization_id",foreignKey = @ForeignKey(name = "fk_organization_id"))
	private Organization organization;

	//bi-directional many-to-one association to OpinionsDrive
	@OneToMany(mappedBy="drive")
	private List<OpinionsDrive> opinionsDrives;
//
	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="savedDrives")
	private List<User> savedDrivesUsers;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="upvotedDrives")
	private List<User> upvotedDrivesUsers;
//
	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="volunteeredDrives")
	private List<User> volunteers;
//
	//bi-directional many-to-one association to ReminderNotification
	@OneToMany(mappedBy="drive")
	private List<ReminderNotification> reminderNotifications;
//
//	//bi-directional many-to-one association to UpvotedNotification
//	@OneToMany(mappedBy="drive")
//	private List<UpvotedNotification> upvotedNotifications;

	public Drive() {
	}

	public Integer getDriveId() {
		return this.driveId;
	}

	public void setDriveId(Integer driveId) {
		this.driveId = driveId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getDuration() {
		return this.duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Integer getUpvotes() {
		return this.upvotes;
	}

	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<OpinionsDrive> getOpinionsDrives() {
		return this.opinionsDrives;
	}

	public void setOpinionsDrives(List<OpinionsDrive> opinionsDrives) {
		this.opinionsDrives = opinionsDrives;
	}

	public OpinionsDrive addOpinionsDrive(OpinionsDrive opinionsDrive) {
		getOpinionsDrives().add(opinionsDrive);
		opinionsDrive.setDrive(this);

		return opinionsDrive;
	}

	public OpinionsDrive removeOpinionsDrive(OpinionsDrive opinionsDrive) {
		getOpinionsDrives().remove(opinionsDrive);
		opinionsDrive.setDrive(null);

		return opinionsDrive;
	}
//
	public List<User> getSavedDrivesUsers() {
		return this.savedDrivesUsers;
	}

	public void setSavedDrivesUsers(List<User> users1) {
		this.savedDrivesUsers = users1;
	}

	public List<User> getUpvotedDrivesUsers() {
		return this.upvotedDrivesUsers;
	}

	public void setUpvotedDrivesUsers(List<User> users2) {
		this.upvotedDrivesUsers = users2;
	}

	public List<User> getVolunteers() {
		return this.volunteers;
	}

	public void setVolunteers(List<User> users3) {
		this.volunteers = users3;
	}
//
	public List<ReminderNotification> getReminderNotifications() {
		return this.reminderNotifications;
	}

	public void setReminderNotifications(List<ReminderNotification> reminderNotifications) {
		this.reminderNotifications = reminderNotifications;
	}

	public ReminderNotification addReminderNotification(ReminderNotification reminderNotification) {
		getReminderNotifications().add(reminderNotification);
		reminderNotification.setDrive(this);

		return reminderNotification;
	}

	public ReminderNotification removeReminderNotification(ReminderNotification reminderNotification) {
		getReminderNotifications().remove(reminderNotification);
		reminderNotification.setDrive(null);

		return reminderNotification;
	}
//


}