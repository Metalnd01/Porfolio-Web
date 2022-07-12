package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Educacion;
import com.porfolio.wkm.Interface.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/educacion")
public class EducacionController {
    
    @Autowired IEducacionService ieducacionService;

    public EducacionController(IEducacionService ieducacionService) {
        this.ieducacionService = ieducacionService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> obtenerEducacion() {
        List<Educacion> educacion = ieducacionService.getEducacion();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
            
    @PutMapping("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion) {
        Educacion updateEducacion = ieducacionService.saveEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion) {
        Educacion nuevaEducacion = ieducacionService.saveEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{idEdu}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("idEdu") Long idEdu){
        ieducacionService.deleteEducacion(idEdu);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
