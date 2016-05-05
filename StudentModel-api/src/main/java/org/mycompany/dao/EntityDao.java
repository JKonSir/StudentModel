package org.mycompany.dao;

import org.mycompany.model.EntityModel;

import java.math.BigInteger;
import java.util.List;

public interface EntityDao<T extends EntityModel>
{
    /**
     * create new entity in database
     * or update entity in database
     *
     * @param entity - entity added or updated
     */
    void createOrUpdate(T entity);

    /**
     * delete entity from database
     *
     * @param entity - entity for delete
     */
    void delete(T entity);

    /**
     * use for get entity from database by identifier
     *
     * @param id - identifier for get entity
     * @return entity form database
     */
    T getEntity(BigInteger id);

    /**
     * use for get list entity from database
     *
     * @return list entity form database
     */
    List<T> getEntities();

}
