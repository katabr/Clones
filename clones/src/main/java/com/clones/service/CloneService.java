package com.clones.service;

import com.clones.dao.entity.Clone;
import com.clones.dao.repository.CloneRepository;
import com.clones.service.base.AbstractTransactionalService;
import com.clones.service.dto.CloneDto;
import com.clones.service.mapper.CloneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CloneService extends AbstractTransactionalService {

    private final CloneRepository cloneRepository;

    @Autowired
    public CloneService(CloneRepository cloneRepository) {
        this.cloneRepository = cloneRepository;
    }

    public List<CloneDto> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return cloneRepository.findAll(em)
                    .stream()
                    .map(CloneMapper::toDto)
                    .collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    public void add(CloneDto dto) {
        EntityManager em = emf.createEntityManager();
        try {
            Clone entity = CloneMapper.toEntity(dto);
            cloneRepository.create(entity, em);
        } finally {
            em.close();
        }
    }

    public void update(CloneDto dto) {
        EntityManager em = emf.createEntityManager();
        try {
            Clone entity = cloneRepository.findByIntegerId(dto.getId(), em);
            entity.setName(dto.getName());
            cloneRepository.save(entity, em);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            Clone entity = cloneRepository.findByIntegerId(id, em);
            cloneRepository.delete(entity, em);
        } finally {
            em.close();
        }
    }


    public CloneDto getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return CloneMapper.toDto(cloneRepository.findByIntegerId(id, em));
        } finally {
            em.close();
        }
    }
}
