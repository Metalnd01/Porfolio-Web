package com.porfolio.wkm.Repository;

import com.porfolio.wkm.Entity.Graficos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGraficosRepository extends JpaRepository<Graficos, Long>{
    
}
