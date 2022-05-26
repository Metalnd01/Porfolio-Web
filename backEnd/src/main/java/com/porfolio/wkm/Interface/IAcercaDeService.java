package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.AcercaDe;
import java.util.List;

public interface IAcercaDeService {
    
    //buscar acercaDe
    public AcercaDe findAcercaDe(Long id);
    
    //agregar un acercaDe
    public void saveAcercaDe(AcercaDe acercaDe);
    
    //eliminar una acercaDe por ID
    public void deleteAcercaDe(Long id);
    
    //mostrar acercaDe
    public List<AcercaDe> getAcercaDe();
        
}
