package com.clones.dao.repository.impl;

import com.clones.dao.entity.Clone;
import com.clones.dao.repository.CloneRepository;
import com.clones.dao.repository.base.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CloneRepositoryImpl extends AbstractJpaRepository<Clone> implements CloneRepository {
    @Override
    public Clone findByIntegerId(Integer id, EntityManager em) {
        return em.createQuery("select b from Clone b where id = :id", Clone.class)
            .setParameter("id", id)
            .getSingleResult();
    }
}
