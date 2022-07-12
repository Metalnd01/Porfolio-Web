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
    
    @Autowired IGraficosRepository igraficosRepository;

    public ImpGraficosService(IGraficosRepository igraficosRepository) {
        this.igraficosRepository = igraficosRepository;
    }
    
    @Override
    public List<Graficos> getGraficos() {
        return igraficosRepository.findAll();
    }

    @Override
    public void deleteGraficos(Long id) {
        igraficosRepository.deleteById(id);
    }
    
    public Graficos editGraficos(Graficos graficos){
        return igraficosRepository.save(graficos);
    }

    @Override
    public Graficos saveGraficos(Graficos graficos) {
        return igraficosRepository.save(graficos);
    }

    @Override
    public Graficos findGraficos(Long idSkill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
