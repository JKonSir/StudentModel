package org.mycompany.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocator
{
    private static volatile ServiceLocator INSTANCE;

    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("APP-INF/spring/spring-ref-context.xml");

    ServiceLocator()
    {
    }

    public static ServiceLocator getInstance()
    {
        ServiceLocator localInstance = INSTANCE;
        if (localInstance == null)
        {
            synchronized (ServiceLocator.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = new ServiceLocator();
                }
                return INSTANCE;
            }
        }

        return localInstance;
    }

    public static <T> T getService(Class<T> clazz)
    {
        return (T) CONTEXT.getBean(clazz);
    }

    public static Object getService(String beanName)
    {
        return CONTEXT.getBean(beanName);
    }

}
