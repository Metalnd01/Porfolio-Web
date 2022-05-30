package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Idiomas;
import java.util.List;

public interface IIdiomasService {
    
    //listado de idiomas aprendidos
    public List<Idiomas> getIdiomas ();
    
    //agregar un idioma
    public Idiomas saveIdiomas(Idiomas idiomas);
    
    //eliminar un idioma por ID
    public void deleteIdiomas(Long id);
    
    //buscar idioma por ID
    public Idiomas findIdiomas(Long id);
}
