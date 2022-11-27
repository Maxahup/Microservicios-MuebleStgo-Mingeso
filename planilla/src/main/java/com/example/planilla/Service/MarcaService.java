package com.example.planilla.Service;

import com.example.planilla.Model.Marca;
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
public class MarcaService {

    @Autowired
    RestTemplate restTemplate;




    public List<Marca> getMarcas(){
        String url = "http://marca/marcas/getAll";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(url, Object[].class);
        Object[] marcasObtenidas = response.getBody();
        if (marcasObtenidas == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(marcasObtenidas)
                .map(Marca -> mapper.convertValue(Marca, Marca.class))
                .collect(Collectors.toList());
    }


}
