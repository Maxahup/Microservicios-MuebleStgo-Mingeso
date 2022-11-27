package com.example.marca.Controller;


import com.example.marca.Entity.Marca;
import com.example.marca.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins="http://localhost:3001")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Marca>> getAll() {
        List<Marca> marcas = marcaService.getAll();
        if(marcas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marcas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Marca> getById(@PathVariable("id") int id){
        Marca marca= marcaService.getMarcaById(id);
        if(marca == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marca);
    }
    @PostMapping("/cargar-uno")
    public ResponseEntity<String> save(@RequestBody Marca marca){
        marcaService.save(marca);
        return ResponseEntity.ok().body("Registro guardado exitosamente");
    }

    @PostMapping("/carga-total")
    public ResponseEntity<Marca> saveAll(@RequestParam("file")MultipartFile file){
        List<Marca> nuevaMarca = marcaService.saveData(file);
        return null;
    }
}
