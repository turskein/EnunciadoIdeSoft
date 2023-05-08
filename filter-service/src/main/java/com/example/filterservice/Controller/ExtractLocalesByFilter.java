package com.example.filterservice.Controller;

import java.util.List;
import com.example.filterservice.Entities.LocalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.example.filterservice.Services.Filters;

@Controller
@RestController
@RequestMapping("/api/v1")
public class ExtractLocalesByFilter {
    @Autowired
    private Filters filters;

    
    @GetMapping(value = "/locales", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<LocalEntity>> getLocalesByFilters(
        @RequestBody(required=false) String name,
        @RequestBody(required=false) String direction,
        @RequestBody(required=false) String fone,
        @RequestBody(required=false) String comuna
        ){
            List<LocalEntity> response = filters.filterservice(name, direction, fone, comuna);
            if(response == null){
                ResponseEntity.badRequest().body("Es nulo el valor retornado");
            }
            return ResponseEntity.ok(response);

    }
    
}
