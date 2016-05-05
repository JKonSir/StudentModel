package org.mycompany.dao.impl;

import org.mycompany.dao.StudentDao;
import org.mycompany.model.Student;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public class StudentDaoImpl implements StudentDao
{
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Student student)
    {
        entityManager.persist(student);
    }

    public void update(Student student)
    {
        entityManager.merge(student);
    }

    public void delete(BigInteger id)
    {
        Student student = getStudent(id);

        entityManager.remove(student);
    }

    public Student getStudent(BigInteger id)
    {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getStudents()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootEntry = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(rootEntry);
        TypedQuery<Student> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }

}
