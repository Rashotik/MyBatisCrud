package com.example.YandexTest.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class City extends AbstractEntity{
    private List<Street> streets;
}
