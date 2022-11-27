package com.example.marca.Service;


import com.example.marca.Entity.Marca;
import com.example.marca.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    public Marca getMarcaById(int id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public void save(Marca marca) {
        Marca nuevaMarca = marcaRepository.save(marca);
        //return nuevaMarca;
    }


    public List<Marca> saveData(MultipartFile file){
        if(!file.isEmpty()){
            try {
                byte [] bytes=file.getBytes();
                String str = new String(bytes, StandardCharsets.UTF_8);
                String[] data = str.split("\n");
                System.out.println("Archivo separado.");
                List<Marca> generadas = generarMarcas(data);
                System.out.println(generadas);
                int cantidadMarcas = generadas.size();
                for (int i=0; i < cantidadMarcas; i++){
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

    public ArrayList<Marca> generarMarcas(String[] arrayLecturas){
        //en esta lista se almacenan las marcas de reloj creadas para cada trabajador
        ArrayList<Marca> marcasGeneradas = new ArrayList<Marca>();
        ArrayList<String> rutsRegistrados = new ArrayList<String>();
        //Integer cantidadLecturas = arrayLecturas.size();
        int cantidadLecturas = arrayLecturas.length;

        //ciclo para encontrar todos los ruts registrados
        for (int i=0 ; i<cantidadLecturas ; i++){
            //String lecturaActual = arrayLecturas.get(i)[];
            String lecturaActual = arrayLecturas[i];
            String[] lecturaSeparada = lecturaActual.split(";");
            if(!rutsRegistrados.contains(lecturaSeparada[2])){
                rutsRegistrados.add(lecturaSeparada[2]);
            }
            System.out.println(rutsRegistrados);
        }
        //ciclo para generar las marcas de cada uno de los ruts
        for (int i=0 ; i< rutsRegistrados.size() ; i++ ){
            int min_10=0;
            int min_25=0;
            int min_45=0;
            int ausencia=0;
            int horasExtras=0;
            for (int j =0; j< cantidadLecturas; j++){
                String marcaActual = arrayLecturas[j];
                //String marcaActual = arrayLecturas.get(j);
                String[] marcaSeparada = marcaActual.split(";");
                if (marcaSeparada[2].equals(rutsRegistrados.get(i))){
                    //obtiene la hor en formato hh:mm
                    String[] horaMarcada=marcaSeparada[1].split(":");
                    int horaLeida = Integer.parseInt(horaMarcada[0]);
                    int minutoLeido = Integer.parseInt(horaMarcada[1]);
                    //verificar ingreso con retraso, se acota hasta las 12 para evitar problemas con
                    //hora de salida
                    if (horaLeida>=7 && horaLeida<12){
                        //retraso de llegada de entre 10 y 25 minutos
                        if (minutoLeido >10 && minutoLeido <= 25){
                            min_10=min_10+1;
                        }
                        if (minutoLeido >25 && minutoLeido <= 45){
                            min_25=min_25+1;
                        }
                        if (minutoLeido >45 && minutoLeido <=59 || (minutoLeido >=0 && minutoLeido<=15 && horaLeida>=9 && horaLeida<=10)){
                            min_45=min_45+1;
                        }
                        if (minutoLeido>15 && horaLeida>=9 && horaLeida<12){
                            ausencia=ausencia+1;
                        }
                    }
                    //Este segmento de codigo se encuentra deshabilitad debido a no ser un requerimiento
                    //el implementar la autorizacion de horas extras (sin autorizacion no se pagan las horas extras)

                    //if (horaLeida>18 && horaLeida<24){
                    //    horasExtras=horasExtras+(horaLeida-18);
                    // }

                }
            }
            Marca nuevaMarca = new Marca(rutsRegistrados.get(i), min_10,min_25,min_45,ausencia );
            marcasGeneradas.add(nuevaMarca);

        }
        return marcasGeneradas;
    }

}
