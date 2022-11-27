package com.example.planilla.Controller;


import com.example.planilla.Entity.Planilla;
import com.example.planilla.Model.Marca;
import com.example.planilla.Model.Personal;
import com.example.planilla.Service.MarcaService;
import com.example.planilla.Service.PersonalService;
import com.example.planilla.Service.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planilla")
@CrossOrigin(origins="http://localhost:3001")
public class PlanillaController {

   @Autowired
   PlanillaService planillaService;

   @Autowired
    PersonalService personalService;
   @Autowired
    MarcaService marcaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Planilla>> getAll(){
        List<Planilla> planillaFull = planillaService.getAll();
        if(planillaFull.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(planillaFull);
    }
    @GetMapping("/getone/{id}")
    public ResponseEntity<Planilla> getById(@PathVariable("id") int id){
        Planilla planillaPersona = planillaService.getPlanillaById(id);
        if(planillaPersona == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planillaPersona);
    }
    @PostMapping("/cargar-planilla")
    public ResponseEntity<String> save(@RequestBody Planilla planilla){
        planillaService.save(planilla);
        return ResponseEntity.ok().body("Planilla guardada exitosamente");
    }

    @PostMapping("/generar-planilla")
    public ResponseEntity<String> generarPlanilla(){
        List<Personal> listadoPersonal = personalService.getPersonal();
        List<Marca> listadoMarcas = marcaService.getMarcas();
        planillaService.generarReporte(listadoPersonal,listadoMarcas);
        return ResponseEntity.ok().body("La planilla de sueldos se ha generado exitosamente");


    }








}
