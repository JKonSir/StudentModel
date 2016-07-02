package org.mycompany.utils;

import org.mycompany.dao.EntityDao;
import org.mycompany.model.Group;
import org.mycompany.model.Student;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

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

    @Inject
    @Named("studentDao")
    private EntityDao<Student> studentDao;

    @Inject
    @Named("groupDao")
    private EntityDao<Group> groupDao;

    @Inject
    private TxUtils txUtils;

    public EntityDao<Student> getStudentDao()
    {
        return studentDao;
    }

    public EntityDao<Group> getGroupDao()
    {
        return groupDao;
    }

    public TxUtils getTxUtils()
    {
        return txUtils;
    }

}
