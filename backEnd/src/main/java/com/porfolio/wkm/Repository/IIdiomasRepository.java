package com.porfolio.wkm.Repository;

import com.porfolio.wkm.Entity.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIdiomasRepository extends JpaRepository<Idiomas, Long>{
    
}
