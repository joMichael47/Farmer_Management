package com.isj.webapp.helloworld.repository;

import com.isj.webapp.helloworld.model.Agriculteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgriculteurRepository extends JpaRepository<Agriculteur, Long> {


    @Query("SELECT a from Agriculteur a WHERE a.nom like:mot_cle or a.region like:mot_cle")
    List<Agriculteur> searchByNomOrRegion(@Param("mot_cle") String mot_cle);
}
