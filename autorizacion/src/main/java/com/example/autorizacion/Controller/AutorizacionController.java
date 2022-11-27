package com.example.autorizacion.Controller;


import com.example.autorizacion.Entity.Autorizacion;
import com.example.autorizacion.Service.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/autorizaciones")
@CrossOrigin(origins="http://localhost:3001")
public class AutorizacionController {

    @Autowired
    AutorizacionService autorizacionService;

    @RequestMapping
    public ResponseEntity<List<Autorizacion>> getAll() {
        List<Autorizacion> autorizaciones = autorizacionService.getAll();
        if(autorizaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autorizaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autorizacion> getById(@PathVariable("id") int id){
        Autorizacion justificativo = autorizacionService.getJustificativoById(id);
        if(justificativo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justificativo);
    }

    @PostMapping("/cargar-uno")
    public ResponseEntity<String> save(@RequestBody Autorizacion justificativo){
        autorizacionService.save(justificativo);
        return ResponseEntity.ok().body("Registro guardado exitosamente");
    }

    @PostMapping("/carga-total")
    public ResponseEntity<Autorizacion> saveAll(@RequestParam("file") MultipartFile file){
        List<Autorizacion> nuevaMarca = autorizacionService.saveData(file);
        return null;
    }


}
