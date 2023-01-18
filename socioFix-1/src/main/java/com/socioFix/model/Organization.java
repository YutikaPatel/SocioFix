package com.socioFix.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Notification.AcceptedNotification;
import com.socioFix.model.Notification.StatusNotification;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@DiscriminatorValue("organization")
@PrimaryKeyJoinColumn(name="organization_id",foreignKey=@ForeignKey(name = "fk_organization_id"))
public class Organization extends User {
	
	


	@Column(name="is_verified")
	private Boolean isVerified;

	@Column(name="unique_id")
	private Integer uniqueId;

	//bi-directional many-to-one association to Drive
	@OneToMany(mappedBy="organization")
	private List<Drive> drives;

//	//bi-directional many-to-one association to OpinionsDrive
//	@OneToMany(mappedBy="organization")
//	private List<OpinionsDrive> opinionsDrives;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="base_location_id",foreignKey = @ForeignKey(name = "fk_base_location_id"))
	private Location base_location;
//
//	//bi-directional many-to-many association to Location
	@ManyToMany
	@JoinTable(
		name="organization_serving_location"
		, joinColumns={
			@JoinColumn(name="organization_id",foreignKey = @ForeignKey(name = "fk_organization_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="location_id",foreignKey = @ForeignKey(name = "fk_location_id"))
			}
		)
	private List<Location> servingLocations; //locations


	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="organization")
	private List<Post> posts;

	//bi-directional many-to-many association to Sector
	@ManyToMany(mappedBy="organizations")
	private List<Sector> sectors;
//
	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="followingOrganizations")
	private List<User> followingUsers;
//
	//bi-directional many-to-one association to UserFollowingOrganization
	@OneToMany(mappedBy="organization")
	private List<UserFollowingOrganization> userFollowingOrganizations;
	
	//bi-directional many-to-one association to AcceptedNotification
	@OneToMany(mappedBy="byOrganization")
	private List<AcceptedNotification> acceptedNotifications;

	

	//bi-directional many-to-one association to StatusNotification
	@OneToMany(mappedBy="byOrganization")
	private List<StatusNotification> statusNotifications;

	public Organization() {
	}



	public Boolean getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Integer getUniqueId() {
		return this.uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	public List<Drive> getDrives() {
		return this.drives;
	}

	public void setDrives(List<Drive> drives) {
		this.drives = drives;
	}

	public Drive addDrive(Drive drive) {
		getDrives().add(drive);
		drive.setOrganization(this);

		return drive;
	}

	public Drive removeDrive(Drive drive) {
		getDrives().remove(drive);
		drive.setOrganization(null);

		return drive;
	}

//	public List<OpinionsDrive> getOpinionsDrives() {
//		return this.opinionsDrives;
//	}
//
//	public void setOpinionsDrives(List<OpinionsDrive> opinionsDrives) {
//		this.opinionsDrives = opinionsDrives;
//	}
//
//	public OpinionsDrive addOpinionsDrive(OpinionsDrive opinionsDrive) {
//		getOpinionsDrives().add(opinionsDrive);
//		opinionsDrive.setOrganization(this);
//
//		return opinionsDrive;
//	}
//
//	public OpinionsDrive removeOpinionsDrive(OpinionsDrive opinionsDrive) {
//		getOpinionsDrives().remove(opinionsDrive);
//		opinionsDrive.setOrganization(null);
//
//		return opinionsDrive;
//	}
//
	public Location getBase_location() {
		return this.base_location;
	}

	public void setBase_location(Location location) {
		this.base_location = location;
	}

	public List<Location> getServingLocations() {
		return this.servingLocations;
	}

	public void setLocations(List<Location> servingLocations) {
		this.servingLocations =servingLocations;
	}
//
//	public User getUser() {
//		return this.user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setOrganization(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setOrganization(null);

		return post;
	}
//
	public List<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
//
	public List<User> getFollowingUsers() {
		return this.followingUsers;
	}

	public void setFollowingUsers(List<User> followingUsers) {
		this.followingUsers = followingUsers;
	}

	public List<UserFollowingOrganization> getUserFollowingOrganizations() {
		return this.userFollowingOrganizations;
	}
//
	public void setUserFollowingOrganizations(List<UserFollowingOrganization> userFollowingOrganizations) {
		this.userFollowingOrganizations = userFollowingOrganizations;
	}

	public UserFollowingOrganization addUserFollowingOrganization(UserFollowingOrganization userFollowingOrganization) {
		getUserFollowingOrganizations().add(userFollowingOrganization);
		userFollowingOrganization.setOrganization(this);

		return userFollowingOrganization;
	}

	public UserFollowingOrganization removeUserFollowingOrganization(UserFollowingOrganization userFollowingOrganization) {
		getUserFollowingOrganizations().remove(userFollowingOrganization);
		userFollowingOrganization.setOrganization(null);

		return userFollowingOrganization;
	}

	public List<AcceptedNotification> getAcceptedNotifications() {
	return this.acceptedNotifications;
}

public void setAcceptedNotifications(List<AcceptedNotification> acceptedNotifications) {
	this.acceptedNotifications = acceptedNotifications;
}

public AcceptedNotification addAcceptedNotification(AcceptedNotification acceptedNotification) {
	getAcceptedNotifications().add(acceptedNotification);
	acceptedNotification.setByOrganization(this);

	return acceptedNotification;
}

public AcceptedNotification removeAcceptedNotification(AcceptedNotification acceptedNotification) {
	getAcceptedNotifications().remove(acceptedNotification);
	acceptedNotification.setByOrganization(null);

	return acceptedNotification;
}

	
	public List<StatusNotification> getStatusNotifications() {
		return this.statusNotifications;
	}

	public void setStatusNotifications(List<StatusNotification> statusNotifications) {
		this.statusNotifications = statusNotifications;
	}

	public StatusNotification addStatusNotification(StatusNotification statusNotification) {
		getStatusNotifications().add(statusNotification);
		statusNotification.setByOrganization(this);

		return statusNotification;
	}

	public StatusNotification removeStatusNotification(StatusNotification statusNotification) {
		getStatusNotifications().remove(statusNotification);
		statusNotification.setByOrganization(null);

		return statusNotification;
	}

}