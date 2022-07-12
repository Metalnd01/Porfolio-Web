package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Proyectos;
import com.porfolio.wkm.Interface.IProyectosService;
import com.porfolio.wkm.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpProyectosService implements IProyectosService {

    @Autowired IProyectosRepository iproyectosRepository;

    
    public ImpProyectosService(IProyectosRepository iproyectosRepository) {
        this.iproyectosRepository = iproyectosRepository;
    }
    
    @Override
    public List<Proyectos> getProyectos() {
        List<Proyectos> proyectos = iproyectosRepository.findAll();
        return proyectos;
    }

    @Override
    public Proyectos saveProyectos(Proyectos proyectos) {
        return iproyectosRepository.save(proyectos);
    }

    @Override
    public void deleteProyectos(Long idProy) {
        iproyectosRepository.deleteById(idProy);
    }

    @Override
    public Proyectos findProyectos(Long idProy) {
        Proyectos proyectos = iproyectosRepository.findById(idProy).orElse(null);
        return proyectos;
    }
    
}
