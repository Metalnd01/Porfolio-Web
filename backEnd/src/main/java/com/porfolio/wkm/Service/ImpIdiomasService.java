package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Idiomas;
import com.porfolio.wkm.Interface.IIdiomasService;
import com.porfolio.wkm.Repository.IIdiomasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpIdiomasService implements IIdiomasService {
    
    @Autowired IIdiomasRepository iidiomasRepository;

    public ImpIdiomasService(IIdiomasRepository iidiomasRepository) {
        this.iidiomasRepository = iidiomasRepository;
    }
    
    @Override
    public List<Idiomas> getIdiomas() {
        return iidiomasRepository.findAll();
    }

    @Override
    public Idiomas saveIdiomas(Idiomas idiomas) {
        return iidiomasRepository.save(idiomas);
    }

    @Override
    public void deleteIdiomas(Long id) {
        iidiomasRepository.deleteById(id);
    }

    public void editIdiomas(Idiomas idiomas) {
        iidiomasRepository.save(idiomas);
    }

    @Override
    public Idiomas findIdiomas(Long idIdioma) {
        Idiomas idiomas = iidiomasRepository.findById(idIdioma).orElse(null);
        return idiomas;
    }
}
