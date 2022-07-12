package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Experiencia;
import com.porfolio.wkm.Interface.IExperienciaService;
import com.porfolio.wkm.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpExperienciaService implements IExperienciaService {

    @Autowired IExperienciaRepository iexperienciaRepository;

    public ImpExperienciaService(IExperienciaRepository iexperienciaRepository) {
        this.iexperienciaRepository = iexperienciaRepository;
    }
    
    @Override
    public List<Experiencia> getExperiencia() {
        return iexperienciaRepository.findAll();
    }

    public Experiencia editExperiencia(Experiencia experiencia) {
        return iexperienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        iexperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia saveExperiencia(Experiencia experiencia) {
        return iexperienciaRepository.save(experiencia);
    }

    @Override
    public Experiencia findExperiencia(Long idExp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
