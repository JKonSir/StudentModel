package org.mycompany.repositories;

import org.mycompany.model.GenericEntity;

import java.math.BigInteger;
import java.util.List;

public interface EntityRepository<T extends GenericEntity>
{
    T save(T entity);

    T update(T entity);

    T findById(BigInteger id);

    T findById(BigInteger id, boolean prefetch);

    List<T> findByIds(List<BigInteger> ids);

    List<T> findAll();

    void delete(BigInteger id);

}
