package com.example.YandexTest.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Country extends AbstractEntity{
    private List<City> cities;
}
