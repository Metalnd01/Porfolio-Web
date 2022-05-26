package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.AcercaDe;
import com.porfolio.wkm.Interface.IAcercaDeService;
import com.porfolio.wkm.Repository.IAcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAcercaDeService implements IAcercaDeService {
    
    @Autowired IAcercaDeRepository iacercaDeRepository;

    @Override
    public AcercaDe findAcercaDe(Long id) {
        AcercaDe acercaDe = iacercaDeRepository.findById(id).orElse(null);
        return acercaDe;
    }

    @Override
    public void saveAcercaDe(AcercaDe acercaDe) {
        iacercaDeRepository.save(acercaDe);
    }

    @Override
    public void deleteAcercaDe(Long id) {
        iacercaDeRepository.deleteById(id);
    }

    @Override
    public List<AcercaDe> getAcercaDe() {
        List<AcercaDe> acercaDe = iacercaDeRepository.findAll();
        return acercaDe;
    }
    
}
