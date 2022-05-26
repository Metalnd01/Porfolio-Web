package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Idiomas;
import com.porfolio.wkm.Interface.IIdiomasService;
import com.porfolio.wkm.Repository.IIdiomasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpIdiomasService implements IIdiomasService {
    
    @Autowired IIdiomasRepository iidiomasRepository;

    @Override
    public List<Idiomas> getIdiomas() {
        List<Idiomas> idiomas = iidiomasRepository.findAll();
        return idiomas;
    }

    @Override
    public void saveIdiomas(Idiomas idiomas) {
        iidiomasRepository.save(idiomas);
    }

    @Override
    public void deleteIdiomas(Long id) {
        iidiomasRepository.deleteById(id);
    }

    @Override
    public Idiomas findIdiomas(Long id) {
        Idiomas idiomas = iidiomasRepository.findById(id).orElse(null);
        return idiomas;
    }
    
}
