package com.clones.dao.repository;

import com.clones.dao.entity.User;
import com.clones.dao.repository.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface UserRepository extends BaseJpaRepository<User> {
    User findByIntegerId(Integer id, EntityManager em);
}
