package com.example.YandexTest.controller;

import com.example.YandexTest.dto.CountryDto;
import com.example.YandexTest.entity.Country;
import com.example.YandexTest.mapper.entity.EntityMapper;
import com.example.YandexTest.service.AbstractService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("country/")
public class CountryController extends AbstractController<Country, CountryDto> {

    public CountryController(AbstractService<Country, CountryDto> entityService,
                             EntityMapper<Country, CountryDto> entityMapper,
                             SqlSessionFactory sqlSessionFactory) {
        super(entityService, entityMapper, sqlSessionFactory);
    }
}
