package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericRepositoryImpl<I, T> implements GenericRepository<I, T> {

    private static Logger logger = LoggerFactory.getLogger(GenericRepositoryImpl.class);

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @SuppressWarnings("unchecked")
    public GenericRepositoryImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void merge(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findById(I id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T getById(I id) {
        T t = findById(id);
        if (t == null) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        return t;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll(int offset, int limit) {
        String query = "from " + entityClass.getName() + " c";
        Query q = entityManager.createQuery(query)
                .setFirstResult(offset)
                .setMaxResults(limit);
        return q.getResultList();
    }
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll() {
        String query = "from " + entityClass.getName() + " c";
        Query q = entityManager.createQuery(query);
        return q.getResultList();
    }

    @Override
    public int getCountOfEntities() {
        String query = "SELECT COUNT(*) FROM " + entityClass.getName() + " c";
        Query q = entityManager.createQuery(query);
        return ((Number) q.getSingleResult()).intValue();
    }
}


