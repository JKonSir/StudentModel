package org.mycompany.mapper;

import org.mycompany.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper
{
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Student student = new Student();
        student.setId(new BigInteger(rs.getBigDecimal("id").toString()));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setAge(rs.getInt("age"));

        return student;
    }
}
