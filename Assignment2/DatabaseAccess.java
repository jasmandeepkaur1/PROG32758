package ca.sheridancollege.Assignment2.Database;

import ca.sheridancollege.Assignment2.beans.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseAccess {
private NamedParameterJdbcTemplate jdbc;
public DatabaseAccess(NamedParameterJdbcTemplate jdbc){
    this.jdbc = jdbc;
}

public List<Student> getStudent(){
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    String query = "SELECT * FROM student ";

    BeanPropertyRowMapper<Student> studentMapper = new BeanPropertyRowMapper<Student>(Student.class);
    List<Student> student = jdbc.query(query  , studentMapper);
    return student;
}


//    public Student getStudentDetails(int id) throws SQLException {
//        Student student = null;
//        PreparedStatement stmt = jdbc.update("SELECT * FROM student WHERE count = ?");
//        stmt.setInt(1, id);
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            // retrieve the student details from the result set
//            String firstName = rs.getString("first_name");
//            String lastName = rs.getString("last_name");
//            String program = rs.getString("program");
//            int year = rs.getInt("year");
//            boolean coop = rs.getBoolean("coop");
//            boolean internship = rs.getBoolean("internship");
//            // create a Student object
//            student = new Student(id, firstName, lastName, program, year, coop, internship);
//        }
//        return student;
//    }
public Student getStudentbyid (int id){
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    String query = "SELECT * FROM student WHERE id = :id";
    namedParameters.addValue("id" , id);
    BeanPropertyRowMapper<Student> mapper = new BeanPropertyRowMapper<>(Student.class);
    Student student =null;
    try{
        student =jdbc.queryForObject(query , namedParameters,mapper);
    }catch (EmptyResultDataAccessException ex){
        System.out.println("Student not found for id " +id);
    }
    return student;

}





}
