package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course;

public class course {

	private int id;
	private String name;
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