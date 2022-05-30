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
public class ImpPersonaService  {
    
    private final IPersonaRepository ipersonaRepository;

    @Autowired
    public ImpPersonaService(IPersonaRepository ipersonaRepository) {
        this.ipersonaRepository = ipersonaRepository;
    }
    
    public List<Persona> getPersona() {
        return ipersonaRepository.findAll();
    }

    public Persona addPersona(Persona persona) {
        return ipersonaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    public Persona editPersona(Persona persona) {
        return ipersonaRepository.save(persona);
    }
    
    public Persona buscarPersonaPorId(Long id){
        return ipersonaRepository.findById(id).orElseThrow(() ->new UserNotFoundException("usuario no encontrado"));
    }
}
