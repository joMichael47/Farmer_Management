package com.isj.webapp.helloworld.service;

import com.isj.webapp.helloworld.model.Agriculteur;
import com.isj.webapp.helloworld.repository.AgriculteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgriculteurServiceImpl implements IAgriculteurService {

    @Autowired
    private AgriculteurRepository agriculteurRepository;


    @Override
    public List<Agriculteur> listeAgriculteurs() {
        return agriculteurRepository.findAll();
    }

    @Override
    public Agriculteur rechercherAgriculteur(Long id) {
        return agriculteurRepository.findById(id).get();
    }

    @Override
    public Agriculteur enregistrerAgriculteur(Agriculteur agriculteur) {
        return agriculteurRepository.save(agriculteur);
    }

    @Override
    public void supprimerAgriculteur(Long id) {
        agriculteurRepository.deleteById(id);
    }

    @Override
    public List<Agriculteur> filtrerParNomOuRegion(String mot_cle) {
        return agriculteurRepository.searchByNomOrRegion(mot_cle);
    }
}
