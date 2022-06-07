package com.clones.dao.repository.impl;

import com.clones.dao.entity.User;
import com.clones.dao.repository.UserRepository;
import com.clones.dao.repository.base.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepositoryImpl extends AbstractJpaRepository<User> implements UserRepository {
    @Override
    public User findByIntegerId(Integer id, EntityManager em) {
        return em.createQuery("from User where id = :id", User.class)
            .setParameter("id", id)
            .getSingleResult();
    }
}
