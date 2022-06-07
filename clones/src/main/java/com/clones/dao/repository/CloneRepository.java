package com.clones.dao.repository;

import com.clones.dao.entity.Clone;
import com.clones.dao.repository.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface CloneRepository extends BaseJpaRepository<Clone> {
    Clone findByIntegerId(Integer id, EntityManager em);
}
