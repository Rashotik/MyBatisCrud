package com.example.YandexTest.mapper.entity;

import com.example.YandexTest.dto.AbstractDto;
import com.example.YandexTest.dto.CityDto;
import com.example.YandexTest.entity.AbstractEntity;
import com.example.YandexTest.entity.City;

import java.util.List;

public interface EntityMapper<E extends AbstractEntity, D extends AbstractDto> {
    List<D> toDto(List<E> cities);
    List<E> toEntity(List<D> cities);

    D toDto(E entity);
    E toEntity(D dto);
}
