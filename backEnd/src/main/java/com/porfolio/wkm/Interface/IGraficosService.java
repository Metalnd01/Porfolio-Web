package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Graficos;
import java.util.List;

public interface IGraficosService {
    
     //listado de personas
    public List<Graficos> getGraficos ();
    
    //agregar una persona
    public void saveGraficos(Graficos graficos);
    
    //eliminar una persona por ID
    public void deleteGraficos(Long id);
    
    //buscar persona por ID
    public Graficos findGraficos(Long id);
}
