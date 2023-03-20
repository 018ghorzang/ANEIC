package aeic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maps")
public class MapsModel {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
    @Column(nullable = true, length = 64)
    private String map;
    
    @Column(nullable = true, length = 255)
    private String description;
    
    private Date  uploadTime;
    
	public MapsModel() {
		
	}

	public MapsModel(Integer id, String map, String description, Date uploadTime) {
		this.id = id;
		this.map = map;
		this.description = description;
		this.uploadTime = uploadTime;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMap() {
		return "/File-package/maps/" + id + "/" + map;
	}

	public void setMap(String map) {
		this.map = map;
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
	
	public String getMapName() {
		return map;
	}

	@Override
	public String toString() {
		return "MapsModel [id=" + id + ", map=" + map + ", description=" + description
				+ ", uploadTime=" + uploadTime + "]";
	}

		
    
}
