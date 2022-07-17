package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Proyectos;
import com.porfolio.wkm.Interface.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    
    @Autowired IProyectosService iproyectosService;

    public ProyectosController(IProyectosService iproyectosService) {
        this.iproyectosService = iproyectosService;
    }
    
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> obtenerProyectos() {
        List<Proyectos> proyectos = iproyectosService.getProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
       
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyectos) {
        Proyectos updateProyectos = iproyectosService.saveProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Proyectos> crearProyectos(@RequestBody Proyectos proyectos) {
        Proyectos nuevaProyectos = iproyectosService.saveProyectos(proyectos);
        return new ResponseEntity<>(nuevaProyectos, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @DeleteMapping("/delete/{idProy}")
    public ResponseEntity<?> borrarProyectos(@PathVariable("idProy") Long idProy){
        iproyectosService.deleteProyectos(idProy);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
