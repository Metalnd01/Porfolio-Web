package com.porfolio.wkm.Repository;

import com.porfolio.wkm.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Long>{
    
}
