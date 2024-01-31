package com.example.YandexTest.mapper;

import com.example.YandexTest.dto.StreetDto;
import com.example.YandexTest.dto.StreetJournalDto;
import com.example.YandexTest.entity.Street;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface StreetMapper extends CommonMapper<Street, StreetDto> {
    @Select("SELECT id, name, city_id as cityId FROM street WHERE id = #{id}")
    Street getById(Integer id);

    @Select("SELECT id, name, city_id as cityId FROM street")
    List<Street> findAll();

    @Select("select id, name, city_id as cityId from street where city_id = #{cityId}")
    List<Street> getStreetsByCityId(Integer cityId);

    @Results(id = "streetJournalMap", value = {
            @Result(property = "streetName", column = "street_name",javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "cityName", column = "city_name",javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "countryName", column = "country_name",javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    @Select("select s.name as street_name, ci.name as city_name, co.name as country_name" +
            "   from street s" +
            "   left join city ci on s.city_id = ci.id" +
            "   left join country co on ci.country_id = co.id" +
            "   group by street_name")
    List<StreetJournalDto> getStreetJournal();

    @Insert("insert into street (id, name, city_id) values (nextval('street_seq'), #{name}, #{cityId})")
    void create(StreetDto dto);

    @Update("update street set (name, city_id) = (#{name}, #{cityId})")
    void update(StreetDto dto);

    @Delete("delete from street where id = #{id}")
    void deleteById(Integer id);
}