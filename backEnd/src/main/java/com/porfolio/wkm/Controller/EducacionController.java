package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Educacion;
import com.porfolio.wkm.Interface.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired IEducacionService ieducacionService;
    
    @GetMapping("educacion/traer")
    public List<Educacion> getEducacion(){
     return ieducacionService.getEducacion();
    }
    
    @PostMapping("educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        ieducacionService.saveEducacion(educacion);
        return "Campo creado correctamente.";
    }
    
    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        ieducacionService.deleteEducacion(id);
        return "Campo borrado correctamente.";
    }
    
    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
                                @RequestParam("imagenEdu") String nuevoImagenEdu,
                                @RequestParam("nombreEdu") String nuevoTituloEdu,
                                @RequestParam("entreAniosEdu") String nuevoEntreAniosEdu,
                                @RequestParam("descripcionEdu") String nuevoDescripcionEdu){
        
        Educacion educacion = ieducacionService.findEducacion(id);
        
        educacion.setImagenEdu(nuevoImagenEdu);
        educacion.setTituloEdu(nuevoTituloEdu);
        educacion.setEntreAniosEdu(nuevoEntreAniosEdu);
        educacion.setDescripcionEdu(nuevoDescripcionEdu);
        
        ieducacionService.saveEducacion(educacion);
        return educacion;
    }
}
