package org.mycompany.dao;

import org.mycompany.model.Student;

import java.math.BigInteger;
import java.util.List;

public interface StudentDao
{
    /**
     * create new entity in database
     *
     * @param student entity to be added to database
     */
    void create(Student student);

    /**
     * update entity in database
     *
     * @param student parameters to be used for update entity in database
     */
    void update(Student student);

    /**
     * delete entity from database
     *
     * @param id - identifier delete entity
     */
    void delete(BigInteger id);

    /**
     * use for get entity from database by identifier
     *
     * @param id - identifier for get entity
     * @return entity form database
     */
    Student getStudent(BigInteger id);

    /**
     * use for get list entity from database
     *
     * @return list entity form database
     */
    List<Student> getStudents();

}
