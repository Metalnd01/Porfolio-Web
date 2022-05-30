package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.AcercaDe;
import com.porfolio.wkm.Interface.IAcercaDeService;
import com.porfolio.wkm.Repository.IAcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpAcercaDeService implements IAcercaDeService {
    
    
    private final IAcercaDeRepository iacercaDeRepository;

    @Autowired 
    public ImpAcercaDeService(IAcercaDeRepository iacercaDeRepository) {
        this.iacercaDeRepository = iacercaDeRepository;
    }
    
    @Override
    public AcercaDe findAcercaDe(Long id) {
        AcercaDe acercaDe = iacercaDeRepository.findById(id).orElse(null);
        return acercaDe;
    }


    public AcercaDe addAcercaDe(AcercaDe acercaDe) {
        return iacercaDeRepository.save(acercaDe);
    }
    
    public AcercaDe editAcercaDe(AcercaDe acercaDe) {
        return iacercaDeRepository.save(acercaDe);
    }

    @Override
    public void deleteAcercaDe(Long id) {
        iacercaDeRepository.deleteById(id);
    }

    @Override
    public List<AcercaDe> getAcercaDe() {
        return iacercaDeRepository.findAll();
    }
    
}
