package com.clones.service;
import com.clones.dao.entity.User;
import com.clones.dao.repository.UserRepository;
import com.clones.service.base.AbstractTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserService extends AbstractTransactionalService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return userRepository.findAll(em);
        } finally {
            em.close();
        }
    }

    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return userRepository.findByIntegerId(id, em);
        } finally {
            em.close();
        }
    }
}
