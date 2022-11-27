package com.example.planilla.Service;


import com.example.planilla.Model.Personal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalService {

    @Autowired
    RestTemplate restTemplate;


    public List<Personal> getPersonal(){
        String url = "http://personal/personal/";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
        Object[] personalRegister = response.getBody();
        if (personalRegister==null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(personalRegister)
                .map(Personal -> mapper.convertValue(Personal, Personal.class))
                .collect(Collectors.toList());
    }


}
