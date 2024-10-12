package com.example.swkom_projekt.service.mapper;

public interface Mapper<S, T> {
    T mapToDto(S source);
}