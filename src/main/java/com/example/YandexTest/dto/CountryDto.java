package com.example.YandexTest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDto extends AbstractDto{
    private List<CityDto> cities;
}
