package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Idiomas;
import com.porfolio.wkm.Interface.IIdiomasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idiomas")
public class IdiomasController {
    
    private final IIdiomasService iidiomasService;

    public IdiomasController(IIdiomasService iidiomasService) {
        this.iidiomasService = iidiomasService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Idiomas>> obtenerIdiomas() {
        List<Idiomas> idiomas = iidiomasService.getIdiomas();
        return new ResponseEntity<>(idiomas, HttpStatus.OK);
    }
            
    @PutMapping("/update")
    public ResponseEntity<Idiomas> editarIdiomas(@RequestBody Idiomas idiomas) {
        Idiomas updateIdiomas = iidiomasService.saveIdiomas(idiomas);
        return new ResponseEntity<>(updateIdiomas, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Idiomas> crearIdiomas(@RequestBody Idiomas idiomas) {
        Idiomas nuevaIdiomas = iidiomasService.saveIdiomas(idiomas);
        return new ResponseEntity<>(nuevaIdiomas, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{idIdioma}")
    public ResponseEntity<?> borrarIdiomas(@PathVariable("idIdioma") Long idIdioma){
        iidiomasService.deleteIdiomas(idIdioma);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
