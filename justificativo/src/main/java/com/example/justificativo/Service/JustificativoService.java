package com.example.justificativo.Service;

import com.example.justificativo.Entity.Justificativo;
import com.example.justificativo.Repository.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class JustificativoService {

    @Autowired
    JustificativoRepository justificativoRepository;


    public List<Justificativo> getAll() {
        return justificativoRepository.findAll();
    }

    public Justificativo getJustificativoById(int id) {
        return justificativoRepository.findById(id).orElse(null);
    }

    public void save(Justificativo justificativo) {
        justificativoRepository.save(justificativo);
    }

    public List<Justificativo> saveData(MultipartFile file){
        if(!file.isEmpty()){
            try {
                byte [] bytes=file.getBytes();
                String str = new String(bytes, StandardCharsets.UTF_8);
                String[] data = str.split("\n");
                List<Justificativo> generadas = generarJustificativos(data);
                System.out.println(generadas);
                int cantidadJustificativos = generadas.size();
                for (int i=0; i < cantidadJustificativos; i++){
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

    public ArrayList<Justificativo> generarJustificativos(String[] arrayLecturas) {
        ArrayList<Justificativo> justificativosGenerados = new ArrayList<Justificativo>();
        ArrayList<String> rutsRegistrados = new ArrayList<String>();
        int cantidadLecturas = justificativosGenerados.size();
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
            int diaActual = Integer.parseInt(entradaSeparada[1]);
            int mesActual = Integer.parseInt(entradaSeparada[2]);
            int annoActual = Integer.parseInt(entradaSeparada[3]);
            boolean justificado = Boolean.parseBoolean(entradaSeparada[4]);
            Justificativo nuevo = new Justificativo(rutActual,diaActual,mesActual,annoActual,justificado);
            justificativosGenerados.add(nuevo);
        }
        return justificativosGenerados;
    }




}
