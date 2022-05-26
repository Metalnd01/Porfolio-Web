package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Idiomas;
import com.porfolio.wkm.Interface.IIdiomasService;
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
public class IdiomasController {
    
    @Autowired IIdiomasService iidiomasService;
    
    @GetMapping("idiomas/traer")
    public List<Idiomas> getIdiomas(){
     return iidiomasService.getIdiomas();
    }
    
    @PostMapping("idiomas/crear")
    public String createIdiomas(@RequestBody Idiomas idiomas){
        iidiomasService.saveIdiomas(idiomas);
        return "Campo creado correctamente.";
    }
    
    @DeleteMapping("/idiomas/borrar/{id}")
    public String deleteIdiomas(@PathVariable Long id){
        iidiomasService.deleteIdiomas(id);
        return "Campo borrado correctamente.";
    }
    
    @PutMapping("/idiomas/editar/{id}")
    public Idiomas editIdiomas(@PathVariable Long id,
                                @RequestParam("url_img_institucion") String nuevoUrl_img_institucion,
                                @RequestParam("nombreIdioma") String nuevoNombreIdioma,
                                @RequestParam("entreAnios") String nuevoEntreAnios,
                                @RequestParam("descripcion") String nuevoDescripcion){
        
        Idiomas idiomas = iidiomasService.findIdiomas(id);
        
        idiomas.setUrl_img_institucion(nuevoUrl_img_institucion);
        idiomas.setEntreAnios(nuevoEntreAnios);
        idiomas.setDescripcion(nuevoDescripcion);
        
        iidiomasService.saveIdiomas(idiomas);
        return idiomas;
    }
}
