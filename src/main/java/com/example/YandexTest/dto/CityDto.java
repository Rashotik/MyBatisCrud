package com.example.YandexTest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDto extends AbstractDto{
    private List<StreetDto> streets;
}
