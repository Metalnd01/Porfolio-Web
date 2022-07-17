package com.porfolio.wkm.Security.Service;

import com.porfolio.wkm.Security.Entity.Rol;
import com.porfolio.wkm.Security.Enums.RolNombre;
import com.porfolio.wkm.Security.Repository.IRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
