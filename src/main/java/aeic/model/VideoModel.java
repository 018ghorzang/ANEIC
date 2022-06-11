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
@Table(name = "video")
public class VideoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	@Column(length = 2000,nullable = false)
	private String description;
	private String videoUrl;
	private Date uploadTime;
	
	
	
	public VideoModel() {

	}

	public VideoModel(Long id, String title, String description, Date uploadTime,String videoUrl) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.uploadTime = uploadTime;
		this.videoUrl = videoUrl;
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
	

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	
	@Transient
	public String getUrlPath() {
		if(videoUrl == null || id == null) return null;
		
		return "/File-package/video/" + id + "/" + videoUrl;
	}

	@Override
	public String toString() {
		return "VideoModel [id=" + id + ", title=" + title + ", description=" + description + ", videoUrl=" + videoUrl
				+ ", uploadTime=" + uploadTime + "]";
	}

	
	
 
   }



