package com.isj.webapp.helloworld.presentation;

import com.isj.webapp.helloworld.model.Agriculteur;
import com.isj.webapp.helloworld.model.User;
import com.isj.webapp.helloworld.service.IAgriculteurService;
import com.isj.webapp.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnnuaireController {

    @Autowired
    private IAgriculteurService iAgriculteurService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String accueil(Model model){

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null)
        {
            final User user = userService.findUserByEmail(auth.getName());
            model.addAttribute("infoUser","Salut " + user.getName() + " " + user.getLastName());
        }else
        {
            model.addAttribute("infoUser","");

        }

        return "index";
    }

    @GetMapping("/liste")
    public String listeagriculteur(Model model){

        List<Agriculteur> agriculteurs = iAgriculteurService.listeAgriculteurs();

        model.addAttribute("agriculteurs",agriculteurs);

        return "liste";
    }

    @GetMapping("/detail")
    public String detailagriculteur(@RequestParam(value = "id") String id, Model model){

        long idAgriculteur= Long.parseLong(id);

        Agriculteur agriculteur = iAgriculteurService.rechercherAgriculteur(idAgriculteur);

        model.addAttribute("agriculteur",agriculteur);

        return "details";
    }

    @GetMapping("/supprime")
    public String supprimeagriculteur(@RequestParam(value = "id") String id){

        long idAgriculteur= Long.parseLong(id);

        iAgriculteurService.supprimerAgriculteur(idAgriculteur);


        return "redirect:liste";
    }

    @GetMapping("/enregistre")
    public String formulaireEnregistre(Model model){

        Agriculteur agriculteurForm=new Agriculteur();

        agriculteurForm.setRegion("Centre");

        model.addAttribute("agriculteurForm",agriculteurForm);

        return "enregistrement";
    }

    @PostMapping ("/enregistreAgriculteur")
    public String enregistreAgriculteur(@ModelAttribute Agriculteur agriculteurForm){

        iAgriculteurService.enregistrerAgriculteur(agriculteurForm);

        return "redirect:liste";
    }

    @GetMapping("/contact")
    public String formulaireContact(Model model){

        return "contact";
    }

    @GetMapping("/recherche")
    public String searchAgri(@RequestParam(value = "mot_cle") String mot_cle, Model model)
    {
        List<Agriculteur> listeagri = iAgriculteurService.filtrerParNomOuRegion(mot_cle);
        model.addAttribute("agriculteurs",listeagri);

        return "liste";
    }

}
