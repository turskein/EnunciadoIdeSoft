package com.example.filterservice.Repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import com.example.filterservice.Entities.LocalEntity;

import io.micrometer.common.util.StringUtils;

import org.sql2o.Connection;

@Repository
public class LocalesRepositoryImp implements LocalesRepository {
    @Autowired
    private Sql2o sql2o;

    
    public String makeQueryByFilter(String name, String  direction, String  fone, String comuna){
        String queryBase = "SELECT * FROM comunas";
        if(StringUtils.isEmpty(name) && StringUtils.isEmpty(direction) && StringUtils.isEmpty(fone) && StringUtils.isEmpty(comuna)){
            return queryBase;
        }
        //Verify which option needs
        ArrayList<String> everyOptionInfo = new ArrayList<>();
        ArrayList<String> everyOption = new ArrayList<>();
        addToArrayIfNotEmpty(everyOptionInfo,everyOption, name, "local_direccion");
        addToArrayIfNotEmpty(everyOptionInfo,everyOption, direction, "local_nombre");
        addToArrayIfNotEmpty(everyOptionInfo,everyOption, fone, "local_telefono");
        addToArrayIfNotEmpty(everyOptionInfo,everyOption, comuna, "comuna_nombre");
        if(everyOption.size() == 1){
            return queryBase + " WHERE " + everyOption.get(0) +" = " + everyOptionInfo.get(0);
        }else{
            String queryReturn = queryBase + " WHERE " + everyOption.get(0) +" = " + everyOptionInfo.get(0);
            for (int i = 1; i < everyOptionInfo.size(); i++) {
                queryReturn = queryReturn + "AND "+ everyOption.get(0) +" = " + everyOptionInfo.get(0);
            }
            return queryReturn;
        }
    }

    private void addToArrayIfNotEmpty(ArrayList<String> options, ArrayList<String> optionsInfo, String info, String option){
        if(!StringUtils.isEmpty(info)){
            options.add(option);
            optionsInfo.add(info);
        }
    }
    
    @Override
    public List<LocalEntity> getLocalesByFilters(String name, String  direction, String  fone, String comuna){
        Connection conn = sql2o.open();
        try(conn){
            return conn.createQuery(makeQueryByFilter(name,direction,fone,comuna)).executeAndFetch(LocalEntity.class);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
