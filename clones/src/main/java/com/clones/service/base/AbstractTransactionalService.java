package com.clones.service.base;

import com.clones.dao.repository.base.BaseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Сервис для базовых операция на данными, обернутыми в транзакцию
 */
public abstract class AbstractTransactionalService {
    @Autowired
    protected EntityManagerFactory emf;

    /**
     * Сохранение сущности в базу
     */
    protected void create(BaseJpaRepository repository, Object item, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            repository.create(item, em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        }
    }

    /**
     * Изменение сущности в базе
     */
    protected void save(BaseJpaRepository repository, Object item, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            repository.save(item, em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        }
    }

    /**
     * Удаление сущности из базы
     */
    protected void delete(BaseJpaRepository repository, Object item, EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            repository.delete(item, em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        }
    }
}
