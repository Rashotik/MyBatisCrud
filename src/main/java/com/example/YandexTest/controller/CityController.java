package com.example.YandexTest.controller;

import com.example.YandexTest.dto.CityDto;
import com.example.YandexTest.entity.City;
import com.example.YandexTest.mapper.entity.EntityMapper;
import com.example.YandexTest.service.AbstractService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController extends AbstractController<City, CityDto> {

    public CityController(AbstractService<City, CityDto> entityService,
                          EntityMapper<City, CityDto> entityMapper,
                          SqlSessionFactory sqlSessionFactory) {
        super(entityService, entityMapper, sqlSessionFactory);
    }
}
