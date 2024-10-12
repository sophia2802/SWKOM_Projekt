package com.example.swkom_projekt.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMapper<S,T> implements Mapper<S,T> {  //maps an object from a specific type to another type
    public List<T> mapToDto(Collection<S> source){
        List<T> targets = new ArrayList<>();
        source.forEach(s ->{
            targets.add(mapToDto(s));
        });
        return targets;
    }
}
