package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.AcercaDe;
import com.porfolio.wkm.Interface.IAcercaDeService;
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
public class AcercaDeController {
    
    @Autowired IAcercaDeService iacercaDeService;
    
    @GetMapping("/acercade/traer")
    public List<AcercaDe> getAcercaDe(){
        return iacercaDeService.getAcercaDe();
    }
    
    @PostMapping("/acercade/crear")
    public String createAcercaDe(@RequestBody AcercaDe acercaDe){
        iacercaDeService.saveAcercaDe(acercaDe);
        return "Campo guardado correctamente";
    }
    
    @DeleteMapping("/acercade/borrar/{id}")
    public String deleteAcercaDe(@PathVariable Long id){
        iacercaDeService.deleteAcercaDe(id);
        return "Campo borrado correctamente";
    }
    
    @PutMapping("/acercade/editar/{id}")
    public AcercaDe editAcercaDe(@PathVariable Long id,
                                @RequestParam("acercaDe") String nuevoAcercaDe){
        
        AcercaDe acercaDe = iacercaDeService.findAcercaDe(id);
        
        acercaDe.setAcercaDe(nuevoAcercaDe);
        
        iacercaDeService.saveAcercaDe(acercaDe);
        return acercaDe;
    }
}
