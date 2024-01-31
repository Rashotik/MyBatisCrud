package com.example.YandexTest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDto extends AbstractDto{
    private List<StreetDto> streets;
}
