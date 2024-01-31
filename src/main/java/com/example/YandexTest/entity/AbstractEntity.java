package com.example.YandexTest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEntity {
    protected Integer id;
    protected String name;
}
