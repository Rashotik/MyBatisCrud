package com.example.YandexTest.mapper.entity;

import com.example.YandexTest.dto.CityDto;
import com.example.YandexTest.dto.StreetDto;
import com.example.YandexTest.entity.City;
import com.example.YandexTest.entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityEntityMapper implements EntityMapper<City, CityDto> {

    @Autowired
    private EntityMapper<Street, StreetDto>  streetMapper;
    @Override
    public List<CityDto> toDto(List<City> entities){
        if (entities == null)
            return null;
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
    @Override
    public List<City> toEntity(List<CityDto> dtos){
        if (dtos == null)
            return null;
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
    @Override
    public CityDto toDto(City entity) {
        if (entity == null)
            return null;
        CityDto dto = new CityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStreets(streetMapper.toDto(entity.getStreets()));
        return dto;
    }

    @Override
    public City toEntity(CityDto dto) {
        return null;
    }
}
