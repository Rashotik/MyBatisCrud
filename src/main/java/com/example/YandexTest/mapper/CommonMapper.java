package com.example.YandexTest.mapper;

import com.example.YandexTest.dto.AbstractDto;
import com.example.YandexTest.entity.AbstractEntity;

import java.util.List;

public interface CommonMapper<E extends AbstractEntity, D extends AbstractDto> {
    E getById(Integer id);

    void create(D dto);

    void update(D dto);

    void deleteById(Integer id);

    List<E> findAll();
}
