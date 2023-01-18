package com.socioFix.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
public class Sector {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sector_id")
	private Integer sectorId;

	private String name;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="sector")
	private List<Post> posts;

	//bi-directional many-to-many association to Organization
	@ManyToMany
	@JoinTable(
		name="organization_serving_sector"
		, joinColumns={
			@JoinColumn(name="sector_id",foreignKey = @ForeignKey(name = "fk_sector_id"))
			}
		, inverseJoinColumns={
			@JoinColumn(name="organization_id",foreignKey = @ForeignKey(name = "fk_organization_id"))
			}
		)
	private List<Organization> organizations;

	public Sector() {
	}

	public Integer getSectorId() {
		return this.sectorId;
	}

	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setSector(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setSector(null);

		return post;
	}

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

}