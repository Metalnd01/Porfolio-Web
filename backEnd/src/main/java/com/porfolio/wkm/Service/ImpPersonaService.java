package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Persona;
import com.porfolio.wkm.Interface.IPersonaService;
import com.porfolio.wkm.Repository.IPersonaRepository;
import com.porfolio.wkm.exception.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService  {
    
    @Autowired IPersonaRepository ipersonaRepository;
    
    
    public ImpPersonaService(IPersonaRepository ipersonaRepository) {
        this.ipersonaRepository = ipersonaRepository;
    }
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public Persona savePersona(Persona persona) {
        return ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    //public Persona editPersona(Persona persona) {
    //    return ipersonaRepository.save(persona);
    //}
    
    @Override
    public Persona findPersona(Long id){
        Persona persona = ipersonaRepository.findById(id).orElseThrow(() ->new UserNotFoundException("usuario no encontrado"));
        return persona;
    }
}
