package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.AcercaDe;
import java.util.List;

public interface IAcercaDeService {
    
    //buscar acercaDe
    public AcercaDe findAcercaDe(Long idAcerca);
    
    //agregar un acercaDe
    public AcercaDe saveAcercaDe(AcercaDe acercaDe);
    
    //eliminar una acercaDe por ID
    public void deleteAcercaDe(Long idAcerca);
    
    //mostrar acercaDe
    public List<AcercaDe> getAcercaDe();
        
}
