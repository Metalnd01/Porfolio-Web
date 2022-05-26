package com.porfolio.wkm.Repository;

import com.porfolio.wkm.Entity.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaDeRepository extends JpaRepository <AcercaDe, Long> {
    
}
