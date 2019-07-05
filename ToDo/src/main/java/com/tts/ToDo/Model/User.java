package com.tts.ToDo.Model;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// User is the entity and object , you create attributes for the user create getters and setters and add an empty contructor
@Entity
//creates the table 
public class User {
   
	private String title;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String description;
	private String author;
	private String status;
	
	User(){};
	User(String title, String description, String author, String status){
		this.title = title;
		this.description = description;
		this.author = author;
		this.status = status;
	}
	public void setRoles(HashSet<User> hashSet) {
		// TODO Auto-generated method stub
		
	}
	public Object getCreator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
	
	

