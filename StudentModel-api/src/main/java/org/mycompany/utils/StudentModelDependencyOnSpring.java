package org.mycompany.utils;

import org.mycompany.model.Group;
import org.mycompany.model.Student;
import org.mycompany.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentModelDependencyOnSpring
{
    private static volatile StudentModelDependencyOnSpring INSTANCE;

    public static StudentModelDependencyOnSpring getInstance()
    {
        if(INSTANCE == null)
        {
            throw new RuntimeException("Spring container not initialized yet.");
        }

        return INSTANCE;
    }

    @PostConstruct
    public void initializeStatic()
    {
        INSTANCE = this;
    }

    @PreDestroy
    public void cleanUp()
    {
        INSTANCE = null;
    }

    @Autowired
    private EntityRepository<Group> groupRepository;

    @Autowired
    private EntityRepository<Student> studentRepository;

    public EntityRepository<Group> getGroupRepository()
    {
        return groupRepository;
    }

    public EntityRepository<Student> getStudentRepository()
    {
        return studentRepository;
    }

}
