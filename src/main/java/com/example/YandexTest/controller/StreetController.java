package com.example.YandexTest.controller;

import com.example.YandexTest.dto.StreetDto;
import com.example.YandexTest.dto.StreetJournalDto;
import com.example.YandexTest.entity.Street;
import com.example.YandexTest.mapper.entity.EntityMapper;
import com.example.YandexTest.service.AbstractService;
import com.example.YandexTest.service.StreetService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street")
public class StreetController extends AbstractController<Street, StreetDto> {
    public StreetController(AbstractService<Street, StreetDto> entityService,
                            EntityMapper<Street, StreetDto> entityMapper,
                            SqlSessionFactory sqlSessionFactory) {
        super(entityService, entityMapper, sqlSessionFactory);
    }

    @RequestMapping(value = "journal", method = RequestMethod.GET)
    public List<StreetJournalDto> getStreetJournal(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StreetService streetService = (StreetService) entityService;
            streetService.setSession(session);
            return streetService.getStreetJournal();
        }
    }
}
