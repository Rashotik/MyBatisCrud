package com.example.YandexTest.service;

import com.example.YandexTest.dto.CityDto;
import com.example.YandexTest.entity.City;
import com.example.YandexTest.mapper.CityMapper;
import com.example.YandexTest.mapper.CommonMapper;
import org.springframework.stereotype.Service;

@Service
public class CityService extends AbstractService<City, CityDto>{

    protected CommonMapper<City, CityDto> getDaoMapperClass() {
        return this.session.getMapper(CityMapper.class);
    }
}
