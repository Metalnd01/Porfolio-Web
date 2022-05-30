package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Graficos;
import com.porfolio.wkm.Interface.IGraficosService;
import com.porfolio.wkm.Repository.IGraficosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpGraficosService implements IGraficosService {
    
    private final IGraficosRepository igraficosRepository;

    @Autowired
    public ImpGraficosService(IGraficosRepository igraficosRepository) {
        this.igraficosRepository = igraficosRepository;
    }
    
    @Override
    public List<Graficos> getGraficos() {
        return igraficosRepository.findAll();
    }

    public Graficos addGraficos(Graficos graficos) {
       return igraficosRepository.save(graficos);
    }

    @Override
    public void deleteGraficos(Long id) {
        igraficosRepository.deleteById(id);
    }
    
    public Graficos editGraficos(Graficos graficos){
        return igraficosRepository.save(graficos);
    }

}
