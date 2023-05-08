package com.example.filterservice.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filterservice.Entities.LocalEntity;

import com.example.filterservice.Repositories.LocalesRepository;

@Service
public class Filters {
    @Autowired
    LocalesRepository localesRepository;

    public List<LocalEntity> filterservice(String name, String  direction, String  fone, String comuna){
        return localesRepository.getLocalesByFilters(name, direction, fone, comuna);
    }
}
