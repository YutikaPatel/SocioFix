package com.socioFix.model;

import java.io.Serializable;
import jakarta.persistence.*;
//import org.postgresql.geometric.PGpolygon;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="location_id")
	private Integer locationId;

	private String area;

	//@Column(name="area_polygon")
	//private PGpolygon areaPolygon;

	private String city;

	private Integer latitude;

	private Integer longtitiude;

	private String state;
	

	//bi-directional many-to-one association to Drive
	@OneToMany(mappedBy="location")
	private List<Drive> drives;
//
//	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="base_location")
	private List<Organization> base_locations;
//
	//bi-directional many-to-many association to Organization
	@ManyToMany(mappedBy="servingLocations")
	private List<Organization> allOrganizationsServingInLocation;//organizations2;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="location")
	private List<Post> posts;

	public Location() {
	}

	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}
//
//	public PGpolygon getAreaPolygon() {
//		return this.areaPolygon;
//	}
//
//	public void setAreaPolygon(PGpolygon areaPolygon) {
//		this.areaPolygon = areaPolygon;
//	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongtitiude() {
		return this.longtitiude;
	}

	public void setLongtitiude(Integer longtitiude) {
		this.longtitiude = longtitiude;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Drive> getDrives() {
		return this.drives;
	}

	public void setDrives(List<Drive> drives) {
		this.drives = drives;
	}

	public Drive addDrive(Drive drive) {
		getDrives().add(drive);
		drive.setLocation(this);

		return drive;
	}

	public Drive removeDrive(Drive drive) {
		getDrives().remove(drive);
		drive.setLocation(null);

		return drive;
	}
//
//	public List<Organization> getOrganizations1() {
//		return this.organizations1;
//	}
//
//	public void setOrganizations1(List<Organization> organizations1) {
//		this.organizations1 = organizations1;
//	}
//
//	public Organization addOrganizations1(Organization organizations1) {
//		getOrganizations1().add(organizations1);
//		organizations1.setLocation(this);
//
//		return organizations1;
//	}
//
//	public Organization removeOrganizations1(Organization organizations1) {
//		getOrganizations1().remove(organizations1);
//		organizations1.setLocation(null);
//
//		return organizations1;
//	}
//
	public List<Organization> getAllOrganizationsServingInLocation() {
		return this.allOrganizationsServingInLocation;
	}

	public void setAllOrganizationsServingInLocation(List<Organization> allOrganizationsServingInLocation) {
		this.allOrganizationsServingInLocation = allOrganizationsServingInLocation;
	}

	
	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setLocation(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setLocation(null);

		return post;
	}

}