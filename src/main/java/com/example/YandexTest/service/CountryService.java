package com.example.YandexTest.service;

import com.example.YandexTest.dto.CountryDto;
import com.example.YandexTest.entity.Country;
import com.example.YandexTest.mapper.CommonMapper;
import com.example.YandexTest.mapper.CountryMapper;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends AbstractService<Country, CountryDto>{

    @Override
    protected CommonMapper<Country, CountryDto> getDaoMapperClass() {
        return session.getMapper(CountryMapper.class);
    }
}
