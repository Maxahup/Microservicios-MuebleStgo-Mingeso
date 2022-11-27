package com.example.autorizacion.Service;


import com.example.autorizacion.Entity.Autorizacion;
import com.example.autorizacion.Repository.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutorizacionService {

    @Autowired
    AutorizacionRepository autorizacionRepository;


    public List<Autorizacion> getAll() {
        return autorizacionRepository.findAll();
    }

    public Autorizacion getJustificativoById(int id) {
        return autorizacionRepository.findById(id).orElse(null);
    }

    public void save(Autorizacion autorizacion) {
        autorizacionRepository.save(autorizacion);
    }

    public List<Autorizacion> saveData(MultipartFile file){
        if(!file.isEmpty()){
            try {
                byte [] bytes=file.getBytes();
                String str = new String(bytes, StandardCharsets.UTF_8);
                String[] data = str.split("\n");
                List<Autorizacion> generadas = generarAutorizaciones(data);
                System.out.println(generadas);
                int cantidadAutorizaciones = generadas.size();
                for (int i=0; i < cantidadAutorizaciones; i++){
                    save(generadas.get(i));
                }
                return generadas;
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("El archivo no se ha cargado porque esta vacio");
        return null;
    }

    public ArrayList<Autorizacion> generarAutorizaciones(String[] arrayLecturas) {
        ArrayList<Autorizacion> autGenerados = new ArrayList<Autorizacion>();
        ArrayList<String> rutsRegistrados = new ArrayList<String>();
        int cantidadLecturas = autGenerados.size();
        //se registran los ruts
        for (int i=0; i<cantidadLecturas; i++){
            String lecturaActual = arrayLecturas[i];
            String[] lecturaSeparada = lecturaActual.split(";");
            if(!rutsRegistrados.contains(lecturaSeparada[0])){
                rutsRegistrados.add(lecturaSeparada[0]);
            }
        }
        for(int i=0; i<cantidadLecturas; i++){
            String entradaActual= arrayLecturas[i];
            String[] entradaSeparada = entradaActual.split(";");
            String rutActual= entradaSeparada[0];
            int horasActual = Integer.parseInt(entradaSeparada[1]);
            Autorizacion nuevo = new Autorizacion(rutActual,horasActual);
            autGenerados.add(nuevo);
        }
        return autGenerados;
    }



}
