package org.mycompany.utils.impl;

import org.mycompany.utils.TxUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;

public class TxUtilsImpl implements TxUtils
{
    @Transactional(propagation = Propagation.MANDATORY)
    public <T> T doInTransactionMandatory(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

    @Transactional(propagation = Propagation.NESTED)
    public <T> T doInTransactionNested(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

    @Transactional(propagation = Propagation.NEVER)
    public <T> T doInTransactionNever(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public <T> T doInTransactionNotSupported(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T doInTransactionRequired(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public <T> T doInTransactionRequiresNew(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public <T> T doInTransactionSupports(Callable<T> callable) throws Exception
    {
        return callable.call();
    }

}
