package com.example.personal.Controller;


import com.example.personal.Entity.Personal;
import com.example.personal.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/personal")
@CrossOrigin(origins="http://localhost:3001")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @GetMapping("/")
    public ResponseEntity<List<Personal>> getAll() {
        List<Personal> todoPersonal = personalService.getAll();
        if(todoPersonal.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(todoPersonal);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Personal> getById(@PathVariable("id") int id){
        Personal personal = personalService.getPersonalById(id);
        if(personal == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personal);
    }
    @PostMapping("/cargar-empleado")
    public ResponseEntity<String> save(@RequestBody Personal personal){
        personalService.save(personal);
        return ResponseEntity.ok().body("Empleado guardado exitosamente");
    }



}
