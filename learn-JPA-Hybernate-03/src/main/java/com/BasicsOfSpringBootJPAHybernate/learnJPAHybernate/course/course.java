package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// @Entity(name="name_of_table") <- Do this to map this class to column with diff name.  
@Entity // In this case, name of class and table is same. So no need to specify name.
public class course {
	@Id // this means it is primary key.
	private int id;
	@Column(name="name") // Similar to above, we dont have to specify @Column if variable name and name in column matches.
	private String name;
	@Column(name="courseAuthor")
	private String courseAuthor;
	
	// we also made a no argu- constructor
	public course() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}

	// Constructor
	public course(int id, String name, String courseAuthor) {
		super();
		this.id = id;
		this.name = name;
		this.courseAuthor = courseAuthor;
	}

	// getter
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCourseAuthor() {
		return courseAuthor;
	}

	// toString
	public String toString() {
		return "course [id=" + id + ", name=" + name + ", courseAuthor=" + courseAuthor + "]";
	}
}