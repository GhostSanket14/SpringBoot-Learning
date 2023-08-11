package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.JDBC.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.course;
import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.courseDelete;

@Repository
public class courseJDBCRepository {

	@Autowired
	private JdbcTemplate springJdbcTempObj; // Basically it is class, whose functions we want to use.
	
	// Try to have query method in all Caps. and also make it text block.
	private String INSERT_QUERY="""
				
					insert into course(id,name,courseAuthor)
					values(?,?,?);

								""";
	
	private String DELETE_QUERY="""
			
					delete from course where id=?;
				
						""";
	
	private String SELECT_QUERY="""
			
			select * from course where id=?;
		
				""";
	
	public void insertFunc(course Course) {
		springJdbcTempObj.update(INSERT_QUERY, 
				Course.getId(),Course.getName(),Course.getCourseAuthor()); 
		// This Issue's a single SQL update operation (such as an insert, update or delete statement)
		// This should be in exact order as per query.
	}			
	public void deleteFunc(courseDelete CourseDel) {
		springJdbcTempObj.update(DELETE_QUERY, CourseDel.getId());
	}
	
	// A Simple alternate, but it wont offer lot of flexibility.
	public void easyDeleteFunc(int passVal) {
		springJdbcTempObj.update(DELETE_QUERY, passVal);
	}
	
	public course easySelectFunc(int passVal) {
		return springJdbcTempObj.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(course.class) ,passVal);
	}
}