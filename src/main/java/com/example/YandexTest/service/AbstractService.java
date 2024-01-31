package com.example.YandexTest.service;

import com.example.YandexTest.dto.AbstractDto;
import com.example.YandexTest.entity.AbstractEntity;
import com.example.YandexTest.mapper.CommonMapper;
import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
public abstract class AbstractService<E extends AbstractEntity, D extends AbstractDto> {

	protected SqlSession session;

	protected abstract CommonMapper<E, D> getDaoMapperClass();

	public E findById(Integer id) {
		CommonMapper<E, D> mapperDao = getDaoMapperClass();
        return mapperDao.getById(id);
	}
	public List<E> findAll() {
		CommonMapper<E, D> mapperDao = getDaoMapperClass();
		return mapperDao.findAll();
	}
	
	@Transactional
	public void create(D dto) {
		CommonMapper<E, D> mapperDao = getDaoMapperClass();
		mapperDao.create(dto);
	}
	
	@Transactional
	public void update(D dto) {
		CommonMapper<E, D> mapperDao = getDaoMapperClass();
		mapperDao.update(dto);
	}
	
	@Transactional
	public void deleteById(Integer entityId) {
		CommonMapper<E, D> mapperDao = getDaoMapperClass();
		mapperDao.deleteById(entityId);
	}

}