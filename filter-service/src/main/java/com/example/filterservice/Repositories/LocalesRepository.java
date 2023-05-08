package com.example.filterservice.Repositories;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.filterservice.Entities.LocalEntity;

@Repository
public interface LocalesRepository {
    List<LocalEntity> getLocalesByFilters(String name, String  direction, String  fone, String comuna);
}
