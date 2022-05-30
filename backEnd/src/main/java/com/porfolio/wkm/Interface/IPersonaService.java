package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    //listado de personas
    public List<Persona> getPersona ();
    
    //agregar una persona
    public Persona savePersona(Persona persona);
    
    //eliminar una persona por ID
    public void deletePersona(Long id);
    
    //buscar persona por ID
    public Persona findPersona(Long id);
}
