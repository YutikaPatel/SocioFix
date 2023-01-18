package com.socioFix.model;


import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import com.socioFix.model.Notification.ContributeNotification;
import com.socioFix.model.Notification.Notification;
import com.socioFix.model.Notification.UpvotedNotification;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class User {

	@Id
	@Column(name="user_id",columnDefinition="TEXT")
	private String userId;

	
	private String bio;

	@Column(name="contact_no")
	private String contactNo;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String name;

	private String password;

	@Column(name="profile_img")
	private String profileImg;

	//bi-directional many-to-one association to OpinionsPost
	@OneToMany(mappedBy="user")
	private List<OpinionsPost> opinionsPosts;
	
	//
	//bi-directional many-to-one association to OpinionsDrive
	@OneToMany(mappedBy="user")
	private List<OpinionsDrive> opinionsDrives;


//
//	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="user")
	private List<Post> posts;
//
	//bi-directional many-to-many association to Drive
	@ManyToMany
	@JoinTable(
		name="saved_drive"
		, joinColumns={
			@JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="drive_id",foreignKey = @ForeignKey(name = "fk_drive_id"))
			}
		)
	private List<Drive> savedDrives;

//	//bi-directional many-to-many association to Drive
	@ManyToMany
	@JoinTable(
		name="upvotes_drive"
		, joinColumns={
			@JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="drive_id",foreignKey = @ForeignKey(name = "fk_drive_id"))
			}
		)
	private List<Drive> upvotedDrives;
//
	//bi-directional many-to-many association to Drive
	@ManyToMany
	@JoinTable(
		name="volunteer"
		, joinColumns={
			@JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="drive_id",foreignKey = @ForeignKey(name = "fk_drive_id"))
			}
		)
	private List<Drive> volunteeredDrives;
////
//	//bi-directional many-to-many association to Organization
	@ManyToMany
	@JoinTable(
		name="user_following_organization"
		, joinColumns={
			@JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="organization_id",foreignKey = @ForeignKey(name = "fk_organization_id"))
			}
		)
	private List<Organization> followingOrganizations;
//
	//bi-directional many-to-many association to Post
	@ManyToMany
	@JoinTable(
		name="saved_post"
		, joinColumns={
			@JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="post_id",foreignKey = @ForeignKey(name = "fk_post_id"))
			}
		)
	private List<Post> savedPosts;//posts2;

	//bi-directional many-to-many association to Post
	@ManyToMany
	@JoinTable(
		name="upvotes_post"
		, joinColumns={
			@JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="post_id",foreignKey = @ForeignKey(name = "fk_post_id"))
			}
		)
 	private List<Post> upvotedPosts;//posts3;
//
	//bi-directional many-to-one association to UserFollowingOrganization
	@OneToMany(mappedBy="user")
	private List<UserFollowingOrganization> userFollowingOrganizations;
//

	//bi-directional many-to-one association to ContributeNotification
	@OneToMany(mappedBy="fromUser")
	private List<ContributeNotification> contributeNotifications;
//
	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="toUser")
	private List<Notification> notifications;

	//bi-directional many-to-one association to UpvotedNotification
	@OneToMany(mappedBy="byUser")
	private List<UpvotedNotification> upvotedNotifications;

	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImg() {
		return this.profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public List<OpinionsPost> getOpinionsPosts() {
		return this.opinionsPosts;
	}

	public void setOpinionsPosts(List<OpinionsPost> opinionsPosts) {
		this.opinionsPosts = opinionsPosts;
	}

	public OpinionsPost addOpinionsPost(OpinionsPost opinionsPost) {
		getOpinionsPosts().add(opinionsPost);
		opinionsPost.setUser(this);

		return opinionsPost;
	}

	public OpinionsPost removeOpinionsPost(OpinionsPost opinionsPost) {
		getOpinionsPosts().remove(opinionsPost);
		opinionsPost.setUser(null);

		return opinionsPost;
	}
	
	//opinions drives 
	public List<OpinionsDrive> getOpinionsDrives() {
	return this.opinionsDrives;
}

public void setOpinionsDrives(List<OpinionsDrive> opinionsDrives) {
	this.opinionsDrives = opinionsDrives;
}

public OpinionsDrive addOpinionsDrive(OpinionsDrive opinionsDrive) {
	getOpinionsDrives().add(opinionsDrive);
	opinionsDrive.setUser(this);

	return opinionsDrive;
}

public OpinionsDrive removeOpinionsDrive(OpinionsDrive opinionsDrive) {
	getOpinionsDrives().remove(opinionsDrive);
	opinionsDrive.setUser(null);

	return opinionsDrive;
}


	public List<Post> getPosts() {
		return this.posts;
	}
//
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPosts(Post posts) {
		getPosts().add(posts);
		posts.setUser(this);

		return posts;
	}

	public Post removePosts(Post posts) {
		getPosts().remove(posts);
		posts.setUser(null);

		return posts;
	}
//
	public List<Drive> getSavedDrives() {
		return this.savedDrives;
	}

	public void setSavedDrives(List<Drive> drives1) {
		this.savedDrives = drives1;
	}

	public List<Drive> getUpvotedDrives() {
		return this.upvotedDrives;
	}

	public void setUpvotedDrives(List<Drive> drives2) {
		this.upvotedDrives = drives2;
	}

	public List<Drive> getVolunteeredDrives() {
		return this.volunteeredDrives;
	}

	public void setVolunteeredDrives(List<Drive> drives3) {
		this.volunteeredDrives = drives3;
	}
//
	public List<Organization> getFollowingOrganizations() {
		return this.followingOrganizations;
	}

	public void setOrganizations(List<Organization> followingOrganizations) {
		this.followingOrganizations = followingOrganizations;
	}

	public List<Post> getSavedPosts() {
		return this.savedPosts;
	}

	public void setSavedPosts(List<Post> savedPosts) {
		this.savedPosts = savedPosts;
	}

	public List<Post> getUpvotedPosts() {
		return this.upvotedPosts;
	}

	public void setUpvotedPosts(List<Post> upvotedPosts) {
		this.upvotedPosts = upvotedPosts;
	}
//
	public List<UserFollowingOrganization> getUserFollowingOrganizations() {
		return this.userFollowingOrganizations;
	}

	public void setUserFollowingOrganizations(List<UserFollowingOrganization> userFollowingOrganizations) {
		this.userFollowingOrganizations = userFollowingOrganizations;
	}

	public UserFollowingOrganization addUserFollowingOrganization(UserFollowingOrganization userFollowingOrganization) {
		getUserFollowingOrganizations().add(userFollowingOrganization);
		userFollowingOrganization.setUser(this);

		return userFollowingOrganization;
	}

	public UserFollowingOrganization removeUserFollowingOrganization(UserFollowingOrganization userFollowingOrganization) {
		getUserFollowingOrganizations().remove(userFollowingOrganization);
		userFollowingOrganization.setUser(null);

		return userFollowingOrganization;
	}
//

	public List<ContributeNotification> getContributeNotifications() {
		return this.contributeNotifications;
	}

	public void setContributeNotifications(List<ContributeNotification> contributeNotifications) {
		this.contributeNotifications = contributeNotifications;
	}

	public ContributeNotification addContributeNotification(ContributeNotification contributeNotification) {
		getContributeNotifications().add(contributeNotification);
		contributeNotification.setFromUser(this);

		return contributeNotification;
	}

	public ContributeNotification removeContributeNotification(ContributeNotification contributeNotification) {
		getContributeNotifications().remove(contributeNotification);
		contributeNotification.setFromUser(null);

		return contributeNotification;
	}
//
	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setToUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setToUser(null);

		return notification;
	}

	// Upvoted Notification
	
	public List<UpvotedNotification> getUpvotedNotifications() {
		return this.upvotedNotifications;
	}

	public void setUpvotedNotifications(List<UpvotedNotification> upvotedNotifications) {
		this.upvotedNotifications = upvotedNotifications;
	}

	public UpvotedNotification addUpvotedNotification(UpvotedNotification upvotedNotification) {
		getUpvotedNotifications().add(upvotedNotification);
		upvotedNotification.setByUser(this);

		return upvotedNotification;
	}

	public UpvotedNotification removeUpvotedNotification(UpvotedNotification upvotedNotification) {
		getUpvotedNotifications().remove(upvotedNotification);
		upvotedNotification.setByUser(null);

		return upvotedNotification;
	}

}