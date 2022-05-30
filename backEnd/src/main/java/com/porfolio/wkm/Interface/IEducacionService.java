package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Educacion;
import java.util.List;

public interface IEducacionService {
    
    //listado de estudios
    public List<Educacion> getEducacion ();
    
    //agregar un item a la lista
    public Educacion saveEducacion(Educacion educacion);
    
    //eliminar un item por ID
    public void deleteEducacion(Long idEdu);
    
    //buscar item por ID
    public Educacion findEducacion(Long idEdu);
}
