package com.example.YandexTest.mapper.entity;

import com.example.YandexTest.dto.StreetDto;
import com.example.YandexTest.entity.Street;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreetEntityMapper implements EntityMapper<Street, StreetDto> {
    @Override
    public List<StreetDto> toDto(List<Street> entities){
        if (entities == null)
            return Collections.emptyList();
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
    @Override
    public List<Street> toEntity(List<StreetDto> dtos){
        if (dtos == null)
            return Collections.emptyList();
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public StreetDto toDto(Street entity) {
        if(entity == null)
            return null;
        StreetDto dto = new StreetDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCityId(entity.getCityId());
        return dto;
    }

    @Override
    public Street toEntity(StreetDto dto) {
        if(dto == null)
            return null;
        Street entity = new Street();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCityId(dto.getCityId());
        return entity;
    }

}
