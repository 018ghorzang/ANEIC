package aeic.model;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class NewsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	@Column(length = 2000,nullable = false)
	private String description;
	private String imageUrl;
	private Date uploadTime;
	
	
	
	public NewsModel() {

	}

	public NewsModel(Long id, String title, String description, Date uploadTime,String imageUrl) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.uploadTime = uploadTime;
		this.imageUrl = imageUrl;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	@Transient
	public String getUrlPath() {
		if(imageUrl == null || id == null) return null;
		
		return "/File-package/image/" + id + "/" + imageUrl;
	}

	@Override
	public String toString() {
		return "NewsModel [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", uploadTime=" + uploadTime + "]";
	}



}
