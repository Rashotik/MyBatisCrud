package com.example.YandexTest.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class City extends AbstractEntity{
    private List<Street> streets;
}
