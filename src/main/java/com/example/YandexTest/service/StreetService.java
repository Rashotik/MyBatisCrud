package com.example.YandexTest.service;

import com.example.YandexTest.dto.StreetDto;
import com.example.YandexTest.dto.StreetJournalDto;
import com.example.YandexTest.entity.Street;
import com.example.YandexTest.mapper.CommonMapper;
import com.example.YandexTest.mapper.StreetMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService extends AbstractService<Street, StreetDto>{

    public List<StreetJournalDto> getStreetJournal(){
        StreetMapper mapperDao = (StreetMapper) getDaoMapperClass();
        return mapperDao.getStreetJournal();
    }
    @Override
    protected CommonMapper<Street, StreetDto> getDaoMapperClass() {
        return session.getMapper(StreetMapper.class);
    }
}
