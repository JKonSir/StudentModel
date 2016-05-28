package org.mycompany.dao.impl;

import org.mycompany.dao.EntityDao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

public class EntityDaoImpl<T extends EntityModel> implements EntityDao<T>
{
    @PersistenceContext(unitName = "entityManager")
    private EntityManager entityManager;

    private final Class<T> type;

    public EntityDaoImpl(Class<T> type)
    {
        this.type = type;
    }

    public void createOrUpdate(T student)
    {
        if (student.getId() == null)
        {
            entityManager.persist(student);
        } else
        {
            entityManager.merge(student);
        }
    }

    public void delete(T entity)
    {
        entityManager.remove(entity);
    }

    public T getEntity(BigInteger id)
    {
        return entityManager.find(type, id);
    }

    public List<T> getEntities()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }

}
