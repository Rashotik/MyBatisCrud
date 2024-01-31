package com.example.YandexTest.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;

@Configuration
public class AppConfig {

//    @Bean
//    public SqlSessionFactory getSqlSessionFactory(){
//        try {
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            return new SqlSessionFactoryBuilder().build(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
