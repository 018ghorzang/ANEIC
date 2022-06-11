package aeic.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
@Table(name = "messages")
public class MessageTable {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
 
 /* Many To One Relationship */
 
 @ManyToOne
 @JoinColumn(name="userid",insertable = false,updatable = false)
 private User user;
 private Integer userid;

 @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date date;
  private String subject;
  @Column(length = 2000,nullable = false)
  private String mess;

public MessageTable() {

}

public MessageTable(Integer id, User user, Integer userid, Date date, String subject, String mess) {
	super();
	this.id = id;
	this.user = user;
	this.userid = userid;
	this.date = date;
	this.subject = subject;
	this.mess = mess;
}

public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public Date getDate() {
	return date;
}



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Integer getUserid() {
	return userid;
}

public void setUserid(Integer userid) {
	this.userid = userid;
}

public void setDate(Date date) {
	this.date = date;
}


public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getMess() {
	return mess;
}

public void setMess(String mess) {
	this.mess = mess;
}

@Override
public String toString() {
	return "MessageTable [id=" + id + ", user=" + user + ", userid=" + userid + ", date=" + date + ", subject="
			+ subject + ", mess=" + mess + "]";
}


}