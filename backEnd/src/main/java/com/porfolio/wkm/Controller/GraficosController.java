package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Graficos;
import com.porfolio.wkm.Interface.IGraficosService;
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
@RequestMapping("/graficos")
public class GraficosController {
    
    @Autowired IGraficosService igraficosService;

    public GraficosController(IGraficosService igraficosService) {
        this.igraficosService = igraficosService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Graficos>> obtenerGraficos() {
        List<Graficos> graficos = igraficosService.getGraficos();
        return new ResponseEntity<>(graficos, HttpStatus.OK);
    }
            
    @PutMapping("/update")
    public ResponseEntity<Graficos> editarGraficos(@RequestBody Graficos graficos) {
        Graficos updateGraficos = igraficosService.saveGraficos(graficos);
        return new ResponseEntity<>(updateGraficos, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Graficos> crearGraficos(@RequestBody Graficos graficos) {
        Graficos nuevaGraficos = igraficosService.saveGraficos(graficos);
        return new ResponseEntity<>(nuevaGraficos, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{idSkill}")
    public ResponseEntity<?> borrarGraficos(@PathVariable("idSkill") Long idSkill){
        igraficosService.deleteGraficos(idSkill);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
