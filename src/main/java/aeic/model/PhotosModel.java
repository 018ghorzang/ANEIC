package aeic.model;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class PhotosModel {
     
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
    @Column(nullable = true, length = 64)
    private String photos;
    @Column(nullable = true, length = 255)
    private String description;
    
    
	public PhotosModel() {
		// TODO Auto-generated constructor stub
	}

	public PhotosModel(String photos) {
		this.photos = photos;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getPhotos() {
		return photos;
	}

	
	 @Transient
	    public String getPhotosImagePath() {
	        if (photos == null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + photos;
	    }
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Photos [id=" + id + ", photos=" + photos + ", description=" + description + "]";
	}

	

    
    // other fields and getters, setters are not shown 
}