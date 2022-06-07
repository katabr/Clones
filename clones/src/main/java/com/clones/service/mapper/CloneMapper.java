package com.clones.service.mapper;

import com.clones.dao.entity.Clone;
import com.clones.service.dto.CloneDto;

public class CloneMapper {
    public static CloneDto toDto(Clone entity) {
        CloneDto dto = new CloneDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static Clone toEntity(CloneDto dto) {
        Clone entity = new Clone();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
