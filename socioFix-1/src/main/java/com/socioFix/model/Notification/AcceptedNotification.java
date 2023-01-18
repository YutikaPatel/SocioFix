package com.socioFix.model.Notification;

import java.io.Serializable;

import com.socioFix.model.Organization;

import jakarta.persistence.*;


/**
 * The persistent class for the accepted_notification database table.
 * 
 */
@Entity
@Table(name="accepted_notification")
@DiscriminatorValue("accepted_notification")
@PrimaryKeyJoinColumn(name="accepted_notification_id",foreignKey=@ForeignKey(name = "fk_accepted_notification_id"))
public class AcceptedNotification extends Notification {
	
	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="by_organization_id",foreignKey=@ForeignKey(name = "fk_organization_id"))
	private Organization byOrganization;

	@Column(columnDefinition = "TEXT default 'Your post has been accepted by an organization!'")
	private String description;

	public AcceptedNotification() {
	}



	public Organization getByOrganization() {
		return this.byOrganization;
	}

	public void setByOrganization(Organization byOrganization) {
		this.byOrganization = byOrganization;
	}

}