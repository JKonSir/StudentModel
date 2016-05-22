package org.mycompany.utils;

import org.mycompany.dao.EntityDao;
import org.mycompany.model.Group;
import org.mycompany.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
    @Qualifier("studentDao")
    private EntityDao<Student> studentDao;

    @Autowired
    @Qualifier("groupDao")
    private EntityDao<Group> groupDao;

    @Autowired
    private TxUtils txUtils;

    public EntityDao getStudentDao()
    {
        return studentDao;
    }

    public EntityDao getGroupDao()
    {
        return groupDao;
    }

    public TxUtils getTxUtils()
    {
        return txUtils;
    }

}
