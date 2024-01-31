package com.example.YandexTest.mapper;

import com.example.YandexTest.dto.CityDto;
import com.example.YandexTest.dto.StreetDto;
import com.example.YandexTest.entity.City;
import com.example.YandexTest.entity.Street;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CityMapper extends CommonMapper<City, CityDto> {

    @Results(id = "cityMap", value = {
            @Result(property = "id", column = "id",javaType = Integer.class, jdbcType = JdbcType.INTEGER,id = true),
            @Result(property = "name", column = "name",javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "streets", column = "id",javaType = List.class, jdbcType = JdbcType.INTEGER,
                    many = @Many(columnPrefix = "city_id",select = "com.example.YandexTest.mapper.StreetMapper.getStreetsByCityId", fetchType = FetchType.EAGER))})
    @Select("SELECT * FROM city WHERE id = #{id}")
    City getById(Integer id);

    @Select("SELECT * FROM city WHERE country_id = #{id}")
    City getCityByCountryId(Integer id);

    @ResultMap("cityMap")
    @Select("SELECT * FROM city")
    List<City> findAll();

    @Insert("insert into city (id, name, country_id) values (nextval('street_seq'), #{name}, #{countryId})")
    void create(CityDto dto);

    @Update("update city set (name, country_id) = (#{name}, #{countryId})")
    void update(CityDto dto);

    @Delete("delete from city where id = #{id}")
    void deleteById(Integer id);
}
