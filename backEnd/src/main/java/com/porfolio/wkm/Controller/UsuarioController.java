package com.porfolio.wkm.Controller;

import com.porfolio.wkm.Entity.Usuario;
import com.porfolio.wkm.Interface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired IUsuarioService iusuarioService;
    
    @PostMapping("usuario/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        iusuarioService.saveUsuario(usuario);
        return "El usuario fue creado correctamente.";
    }
    
    @DeleteMapping("/usuario/borrar/{email}")
    public String deleteUsuario(@PathVariable Usuario email){
        iusuarioService.deleteUsuario(email);
        return "El usuario fue borrado correctamente.";
    }
    
    @PutMapping("/usuario/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
                                @RequestParam("email") String nuevoEmail,
                                @RequestParam("password") String nuevoPassword){
    Usuario usuario = iusuarioService.findUsuario(id);
        
        usuario.setEmail(nuevoEmail);
        usuario.setPassword(nuevoPassword);
        
        iusuarioService.saveUsuario(usuario);
        return usuario;
    }
}
