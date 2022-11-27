package com.example.justificativo.Controller;


import com.example.justificativo.Entity.Justificativo;
import com.example.justificativo.Service.JustificativoService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/justificativos")
@CrossOrigin(origins="http://localhost:3001")
public class JustificativoController {

    @Autowired
    JustificativoService justificativoService;

    @RequestMapping
    public ResponseEntity<List<Justificativo>> getAll() {
        List<Justificativo> justificativos = justificativoService.getAll();
        if(justificativos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(justificativos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Justificativo> getById(@PathVariable("id") int id){
        Justificativo justificativo = justificativoService.getJustificativoById(id);
        if(justificativo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justificativo);
    }

    @PostMapping("/cargar-uno")
    public ResponseEntity<String> save(@RequestBody Justificativo justificativo){
        justificativoService.save(justificativo);
        return ResponseEntity.ok().body("Registro guardado exitosamente");
    }

    @PostMapping("/carga-total")
    public ResponseEntity<Justificativo> saveAll(@RequestParam("file")MultipartFile file){
        List<Justificativo> nuevaMarca = justificativoService.saveData(file);
        return null;
    }

}
