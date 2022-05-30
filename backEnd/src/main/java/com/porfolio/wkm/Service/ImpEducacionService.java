package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Educacion;
import com.porfolio.wkm.Interface.IEducacionService;
import com.porfolio.wkm.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpEducacionService implements IEducacionService {

    private final IEducacionRepository ieducacionRepository;

    @Autowired
    public ImpEducacionService(IEducacionRepository ieducacionRepository) {
        this.ieducacionRepository = ieducacionRepository;
    }
    
    
    @Override
    public List<Educacion> getEducacion() {
        return ieducacionRepository.findAll();
    }

    public Educacion addEducacion(Educacion educacion) {
        return ieducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long idEdu) {
        ieducacionRepository.deleteById(idEdu);
    }

    public Educacion editEducacion(Educacion educacion){
        return ieducacionRepository.save(educacion);
    }

    
}
