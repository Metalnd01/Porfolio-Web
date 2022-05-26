package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Experiencia;
import com.porfolio.wkm.Interface.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired IExperienciaService iexperienciaService;
    
    @GetMapping("experiencia/traer")
    public List<Experiencia> getExperiencia(){
     return iexperienciaService.getExperiencia();
    }
    
    @PostMapping("experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        iexperienciaService.saveExperiencia(experiencia);
        return "Campo creado correctamente.";
    }
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        iexperienciaService.deleteExperiencia(id);
        return "Campo borrado correctamente.";
    }
    
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                                @RequestParam("url_img_empresa") String nuevoUrl_img_empresa,
                                @RequestParam("nombreEmpresa") String nuevoNombreEmpresa,
                                @RequestParam("entreAnios") String nuevoEntreAnios,
                                @RequestParam("descripcion") String nuevoDescripcion){
        
        Experiencia experiencia = iexperienciaService.findExperiencia(id);
        
        experiencia.setUrl_img_empresa(nuevoUrl_img_empresa);
        experiencia.setNombreEmpresa(nuevoNombreEmpresa);
        experiencia.setEntreAnios(nuevoEntreAnios);
        experiencia.setDescripcion(nuevoDescripcion);
        
        iexperienciaService.saveExperiencia(experiencia);
        return experiencia;
    }
}
