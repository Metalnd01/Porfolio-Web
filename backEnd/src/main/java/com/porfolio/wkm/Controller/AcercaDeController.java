package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.AcercaDe;
import com.porfolio.wkm.Interface.IAcercaDeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercaDe")
public class AcercaDeController {
    
    private final IAcercaDeService iacercaDeService;

    public AcercaDeController(IAcercaDeService iacercaDeService) {
        this.iacercaDeService = iacercaDeService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AcercaDe>> obtenerAcercaDe() {
        List<AcercaDe> acercaDe = iacercaDeService.getAcercaDe();
        return new ResponseEntity<>(acercaDe, HttpStatus.OK);
    }
            
    @PutMapping("/update")
    public ResponseEntity<AcercaDe> editarAcercaDe(@RequestBody AcercaDe acercaDe) {
        AcercaDe updateAcercaDe = iacercaDeService.saveAcercaDe(acercaDe);
        return new ResponseEntity<>(updateAcercaDe, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<AcercaDe> crearAcercaDe(@RequestBody AcercaDe acercaDe) {
        AcercaDe nuevaAcercaDe = iacercaDeService.saveAcercaDe(acercaDe);
        return new ResponseEntity<>(nuevaAcercaDe, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{idAcerca}")
    public ResponseEntity<?> borrarAcercaDe(@PathVariable("idAcerca") Long idAcerca){
        iacercaDeService.deleteAcercaDe(idAcerca);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
