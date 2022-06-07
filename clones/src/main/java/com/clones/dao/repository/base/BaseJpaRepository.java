package com.clones.dao.repository.base;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

/***
 * Базовый интерфейс для всех репозиториев уровня доступа к данным.
 * @param <T>
 */
public interface BaseJpaRepository<T> {
    /***
     * Сохраняет запись в БД. Если записи не было, создает ее.
     * @return сохраненную сущность
     */
    T create(T entity, EntityManager em);

    T save(T entity, EntityManager em);

    void delete(T entity, EntityManager em);

    void deleteById(UUID id, EntityManager em);

    T findById(UUID id, EntityManager em);

    List<T> findAll(EntityManager em);
}
