package org.mycompany.facade;

import org.mycompany.dao.StudentDao;
import org.mycompany.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.List;

public class StudentFacade
{
    private StudentDao studentDao;

    public void create(Student student)
    {
        getStudentDao().create(student);
    }

    public void update(Student student)
    {
        getStudentDao().update(student);
    }

    public void delete(BigInteger id)
    {
        getStudentDao().delete(id);
    }

    public Student getStudent(BigInteger id)
    {
        return getStudentDao().getStudent(id);
    }

    public List<Student> getStudents()
    {
        return getStudentDao().getStudents();
    }

    private StudentDao getStudentDao()
    {
        if (studentDao == null)
        {
            ApplicationContext context =
                    new ClassPathXmlApplicationContext("spring/spring-context-entity.xml");

            studentDao = context.getBean(StudentDao.class);
        }

        return studentDao;
    }

}
