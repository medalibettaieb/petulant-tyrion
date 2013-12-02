package tn.esprit.zoomonster.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Student implements Serializable{
	
	private static final long serialVersionUID = -1573281680372763872L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne(cascade = CascadeType.MERGE)
	private MediaItem picture;
	
	public Student() {
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

	public MediaItem getPicture() {
		return picture;
	}

	public void setPicture(MediaItem picture) {
		this.picture = picture;
	}
	
	
	
	

}
