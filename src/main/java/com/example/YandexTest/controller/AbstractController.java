package com.example.YandexTest.controller;

import com.example.YandexTest.dto.AbstractDto;
import com.example.YandexTest.entity.AbstractEntity;
import com.example.YandexTest.mapper.entity.EntityMapper;
import com.example.YandexTest.service.AbstractService;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
public abstract class AbstractController<E extends AbstractEntity, D extends AbstractDto> {

    protected SqlSessionFactory sqlSessionFactory;

    protected AbstractService<E, D> entityService;
    protected EntityMapper<E, D> entityMapper;

    @Autowired
    public AbstractController(AbstractService<E, D> entityService,
                              EntityMapper<E, D> entityMapper,
                              SqlSessionFactory sqlSessionFactory) {
        this.entityService = entityService;
        this.entityMapper = entityMapper;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public D findById(@PathVariable("id") Integer id){
        try (SqlSession session = sqlSessionFactory.openSession()){
            entityService.setSession(session);
            return entityMapper.toDto(entityService.findById(id));
        }
    }

    @RequestMapping(value = "/all", method =  RequestMethod.GET)
    public List<D> findAll(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            entityService.setSession(session);
            return entityMapper.toDto(entityService.findAll());
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody D dto) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            entityService.setSession(session);
            entityService.create(dto);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update( @RequestBody D dto) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            entityService.setSession(session);
            entityService.update(dto);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            entityService.setSession(session);
            entityService.deleteById(id);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

}
