package com.example.YandexTest.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Country extends AbstractEntity{
    private List<City> cities;
}
