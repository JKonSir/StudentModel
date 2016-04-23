package org.mycompany.dao.impl;

import org.mycompany.dao.StudentDao;
import org.mycompany.mapper.StudentMapper;
import org.mycompany.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Transactional
public class StudentDaoImpl implements StudentDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(final Student student)
    {
        final String sql = "INSERT INTO student (first_name, last_name, age) VALUES (?, ?, ?)";

        jdbcTemplate.update(new PreparedStatementCreator()
        {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setInt(3, student.getAge());

                return preparedStatement;
            }
        });

        System.out.println("Created student: " + student);
    }

    public void update(final Student student)
    {
        final String sql = "UPDATE student SET first_name = ?, last_name = ?, age = ? WHERE id = ?";

        jdbcTemplate.update(new PreparedStatementCreator()
        {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setBigDecimal(4, new BigDecimal(student.getId().toString()));

                return preparedStatement;
            }
        });

        System.out.println("Update student with id: " + student.getId());
    }

    public void delete(final BigInteger id)
    {
        final String sql = "DELETE FROM student WHERE id = ?";

        jdbcTemplate.update(new PreparedStatementCreator()
        {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBigDecimal(1, new BigDecimal(id.toString()));

                return preparedStatement;
            }
        });

        System.out.println("Delete student with id: " + id);
    }

    public Student getStudent(BigInteger id)
    {
        final String SQL = "SELECT * FROM student WHERE id = ?";
        Student student = (Student) jdbcTemplate.queryForObject(SQL,
                new Object[]{new BigDecimal(id.toString())}, new StudentMapper());
        return student;
    }

    public List<Student> getStudents()
    {
        final String sql = "SELECT * FROM student";
        List<Student> students = jdbcTemplate.query(sql,
                new StudentMapper());
        return students;
    }

}
