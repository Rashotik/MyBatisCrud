package com.example.YandexTest.mapper;

import com.example.YandexTest.dto.CountryDto;
import com.example.YandexTest.entity.Country;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CountryMapper extends CommonMapper<Country, CountryDto>{

    @Results(id = "cityMap", value = {
            @Result(property = "id", column = "id",javaType = Integer.class, jdbcType = JdbcType.INTEGER,id = true),
            @Result(property = "name", column = "name",javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "cities", column = "id",javaType = List.class, jdbcType = JdbcType.INTEGER,
                    many = @Many(columnPrefix = "country_id",select = "com.example.YandexTest.mapper.CityMapper.getCityByCountryId", fetchType = FetchType.EAGER))})
    @Select("SELECT * FROM country WHERE id = #{id}")
    Country getById(Integer id);

    @Select("SELECT * FROM country")
    List<Country> findAll();

    @Insert("insert into country (id, name) values (nextval('country_seq'), #{name})")
    void create(CountryDto dto);

    @Update("update country set name = #{name}")
    void update(CountryDto dto);

    @Delete("delete from country where id = #{id}")
    void deleteById(Integer id);
}
