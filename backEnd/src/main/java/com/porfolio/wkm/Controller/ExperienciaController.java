package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Experiencia;
import com.porfolio.wkm.Interface.IExperienciaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {
    
    @Autowired IExperienciaService iexperienciaService;

    public ExperienciaController(IExperienciaService iexperienciaService) {
        this.iexperienciaService = iexperienciaService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> obtenerExperiencia() {
        List<Experiencia> experiencia = iexperienciaService.getExperiencia();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
            
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia updateExperiencia = iexperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia nuevaExperiencia = iexperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{idExp}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("idExp") Long idExp){
        iexperienciaService.deleteExperiencia(idExp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
