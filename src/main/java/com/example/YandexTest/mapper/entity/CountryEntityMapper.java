package com.example.YandexTest.mapper.entity;

import com.example.YandexTest.dto.CountryDto;
import com.example.YandexTest.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryEntityMapper implements EntityMapper<Country, CountryDto> {
    @Autowired
    private CityEntityMapper cityMapper;
    @Override
    public List<Country> toEntity(List<CountryDto> dtos){
        if (dtos == null)
            return Collections.emptyList();
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
    @Override
    public List<CountryDto> toDto(List<Country> entities){
        if (entities == null)
            return Collections.emptyList();
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
    @Override
    public CountryDto toDto(Country entity) {
        if(entity == null)
            return null;
        CountryDto dto = new CountryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCities(cityMapper.toDto(entity.getCities()));
        return dto;
    }

    @Override
    public Country toEntity(CountryDto dto) {
        if(dto == null)
            return null;
        Country entity = new Country();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCities(cityMapper.toEntity(dto.getCities()));
        return entity;
    }
}
