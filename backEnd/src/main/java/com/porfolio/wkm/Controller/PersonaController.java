package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Persona;
import com.porfolio.wkm.Interface.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")

public class PersonaController {
    
    private final IPersonaService ipersonaService;

    public PersonaController(IPersonaService ipersonaService) {
        this.ipersonaService = ipersonaService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable("id") Long id) {
        Persona persona = ipersonaService.findPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
            
    @PutMapping("/update")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona) {
        Persona updatePersona = ipersonaService.savePersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }
    
}
