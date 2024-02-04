package com.backend.alianza.genericService;

import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LaptopSA
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID extends Serializable> {

    @Transactional
    public T save(T entity);

    @Transactional(readOnly = true)
    public T findById(ID id);

    @Transactional(readOnly = true)
    public List<T> findByAll();

    @Transactional
    public void delete(ID id);
}