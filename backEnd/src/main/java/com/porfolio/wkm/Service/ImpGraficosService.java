package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Graficos;
import com.porfolio.wkm.Interface.IGraficosService;
import com.porfolio.wkm.Repository.IGraficosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpGraficosService implements IGraficosService {
    
    @Autowired IGraficosRepository igraficosRepository;

    @Override
    public List<Graficos> getGraficos() {
        List<Graficos> graficos = igraficosRepository.findAll();
        return graficos;
    }

    @Override
    public void saveGraficos(Graficos graficos) {
        igraficosRepository.save(graficos);
    }

    @Override
    public void deleteGraficos(Long id) {
        igraficosRepository.deleteById(id);
    }

    @Override
    public Graficos findGraficos(Long id) {
        Graficos graficos = igraficosRepository.findById(id).orElse(null);
        return graficos;
    }
    
}
