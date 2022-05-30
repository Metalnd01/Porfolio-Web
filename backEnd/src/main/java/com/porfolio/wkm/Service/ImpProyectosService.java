package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Proyectos;
import com.porfolio.wkm.Interface.IProyectosService;
import com.porfolio.wkm.Repository.IProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpProyectosService implements IProyectosService {

    private final IProyectosRepository iproyectosRepository;

    @Autowired
    public ImpProyectosService(IProyectosRepository iproyectosRepository) {
        this.iproyectosRepository = iproyectosRepository;
    }
    
    @Override
    public List<Proyectos> getProyectos() {
        return iproyectosRepository.findAll();
    }

    public void addProyectos(Proyectos proyectos) {
        iproyectosRepository.save(proyectos);
    }

    @Override
    public void deleteProyectos(Long id) {
        iproyectosRepository.deleteById(id);
    }

    public void editProyectos(Proyectos proyectos) {
        iproyectosRepository.save(proyectos);
    }
    
}
