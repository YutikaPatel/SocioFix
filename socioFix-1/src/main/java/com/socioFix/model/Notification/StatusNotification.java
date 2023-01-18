package com.socioFix.model.Notification;

import java.io.Serializable;

import com.socioFix.model.Organization;

import jakarta.persistence.*;


/**
 * The persistent class for the status_notification database table.
 * 
 */
@Entity
@Table(name="status_notification")
@DiscriminatorValue("status_notification")
@PrimaryKeyJoinColumn(name="status_notification_id",foreignKey=@ForeignKey(name = "fk_status_notification_id"))
public class StatusNotification extends Notification {
	

	//bi-directional many-to-one association to Organization
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="by_organization_id")
	private Organization byOrganization;

	//custom message
	@Column(columnDefinition = "TEXT")
	private String description;
	
	public StatusNotification() {
	}

	
	
	public Organization getByOrganization() {
		return this.byOrganization;
	}

	public void setByOrganization(Organization organization) {
		this.byOrganization = organization;
	}


}