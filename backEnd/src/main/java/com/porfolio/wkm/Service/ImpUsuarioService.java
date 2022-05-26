package com.porfolio.wkm.Service;

import com.porfolio.wkm.Entity.Usuario;
import com.porfolio.wkm.Interface.IUsuarioService;
import com.porfolio.wkm.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpUsuarioService implements IUsuarioService {

    @Autowired IUsuarioRepository iusuarioRepository;
    
    @Override
    public void saveUsuario(Usuario email) {
        iusuarioRepository.save(email);
    }

    @Override
    public void deleteUsuario(Usuario email) {
        iusuarioRepository.delete(email);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = iusuarioRepository.findById(id).orElse(null);
        return usuario;
    }
    
}
