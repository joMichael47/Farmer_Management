package com.isj.webapp.helloworld.presentation.api;

import com.isj.webapp.helloworld.model.Agriculteur;
import com.isj.webapp.helloworld.service.IAgriculteurService;
import com.isj.webapp.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annuaire/api")
public class AnnuaireControllerRest {

    @Autowired
    IAgriculteurService iAgriculteurService;

    @RequestMapping(value = "/listes",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agriculteur> listAgriculteurs(){
        List<Agriculteur> listeAgriculteurs =iAgriculteurService.listeAgriculteurs();
        return listeAgriculteurs;
    }

    @RequestMapping(value="/agriculteur/{mot_cle}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agriculteur> listeAgriculteurMotcle(@PathVariable String mot_cle){
        List<Agriculteur> agriculteurs = iAgriculteurService.filtrerParNomOuRegion(mot_cle);

        return agriculteurs;
    }

    @RequestMapping(value="/save", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveAgriculteur(@RequestBody Agriculteur agriculteur){
        System.out.println(agriculteur);
        iAgriculteurService.enregistrerAgriculteur(agriculteur);
    }

}
