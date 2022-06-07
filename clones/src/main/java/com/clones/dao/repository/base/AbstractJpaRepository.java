package com.clones.dao.repository.base;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

public abstract class AbstractJpaRepository<T> implements BaseJpaRepository<T> {

    private Class<T> entityBeanType;

    Class<T> getEntityBeanType() {
        return entityBeanType;
    }

    /***
     * Получаем информацию из рантайма о типе класса
     */
    @SuppressWarnings("unchecked")
    public AbstractJpaRepository() {
        this.entityBeanType = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public T create(T entity, EntityManager em) {
        em.persist(entity);
        return entity;
    }

    @Override
    public T save(T entity, EntityManager em) {
        return em.merge(entity);
    }

    @Override
    public T findById(UUID id, EntityManager em) {
        return em.find(getEntityBeanType(), id);
    }

    @Override
    public void delete(T entity, EntityManager em) {
        em.remove(entity);
    }

    @Override
    public void deleteById(UUID id, EntityManager em) {
        T t = em.find(getEntityBeanType(), id);
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll(EntityManager em) {
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(getEntityBeanType());
        criteriaQuery.from(getEntityBeanType());
        return em.createQuery(criteriaQuery).getResultList();
    }
}
