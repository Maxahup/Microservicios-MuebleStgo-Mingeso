package com.example.personal.Service;

import com.example.personal.Entity.Personal;
import com.example.personal.Repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    public List<Personal> getAll() {
        return personalRepository.findAll();
    }

    public Personal getPersonalById(int id) {
        Personal buscado = personalRepository.findById(id).orElse(null);
        return buscado;
    }

    public void save(Personal personal) {
        personalRepository.save(personal);
    }



}
