package aeic.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class DocumentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 512, nullable = false, unique = true)
	private String name;
	
	@Column(length = 1000,nullable = false)
	private String  description;
	
	private long size;
	private Date uploadTime;

	

	public DocumentModel(Long id, String name, long size, Date uploadTime,String description) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.uploadTime = uploadTime;
		this.description = description;
	}

	public DocumentModel() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
		

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "DocumentModel [id=" + id + ", name=" + name + ", description=" + description + ", size=" + size
				+ ", uploadTime=" + uploadTime + "]";
	}

	
	

}
