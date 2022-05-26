package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Graficos;
import com.porfolio.wkm.Interface.IGraficosService;
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
public class GraficosController {
    
    @Autowired IGraficosService igraficosService;

    @GetMapping("graficos/traer")
    public List<Graficos> getGraficos(){
     return igraficosService.getGraficos();
    }
    
    @PostMapping("graficos/crear")
    public String createGraficos(@RequestBody Graficos graficos){
        igraficosService.saveGraficos(graficos);
        return "Grafico creado correctamente.";
    }
    
    @DeleteMapping("/graficos/borrar/{id}")
    public String deleteGraficos(@PathVariable Long id){
        igraficosService.deleteGraficos(id);
        return "Grafico borrado correctamente.";
    }
    
    @PutMapping("/graficos/editar/{id}")
    public Graficos editGraficos(@PathVariable Long id,
                                @RequestParam("nombre_skill") String nuevoNombre_skill,
                                @RequestParam("porcentaje") Long nuevoPorcentaje){
        
        Graficos graficos = igraficosService.findGraficos(id);
        
        graficos.setNombre_skill(nuevoNombre_skill);
        graficos.setPorcentaje(nuevoPorcentaje);
        
        igraficosService.saveGraficos(graficos);
        return graficos;
    } 
}
