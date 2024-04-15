package com.eazybytes.entity;

public interface EntityBuilder<T> {

    EntityBuilder<T> setId(Integer id);

    T build();
}
