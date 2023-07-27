package com.isj.webapp.helloworld.service;

import com.isj.webapp.helloworld.model.Agriculteur;

import java.util.List;

public interface IAgriculteurService {
    List<Agriculteur> listeAgriculteurs();
    Agriculteur rechercherAgriculteur(Long id);
    Agriculteur enregistrerAgriculteur(Agriculteur agriculteur);
    void supprimerAgriculteur(Long id);
    List<Agriculteur> filtrerParNomOuRegion(String mot_cle);
}
