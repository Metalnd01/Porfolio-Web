package com.porfolio.wkm.Interface;

import com.porfolio.wkm.Entity.Usuario;


public interface IUsuarioService {
    
    //agregar un usuario
    public void saveUsuario(Usuario email);
    
    //eliminar un Usuario por Email
    public void deleteUsuario(Usuario email);
    
    //buscar usuario por ID
    public Usuario findUsuario(Long id);
}
