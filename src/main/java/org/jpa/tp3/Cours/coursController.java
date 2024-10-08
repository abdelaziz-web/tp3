package org.jpa.tp3.Cours;

import java.util.List;
import java.util.Optional;
import  org.jpa.tp3.Cours.cours;
import  org.jpa.tp3.Modules.*;
import org.jpa.tp3.Modules.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class coursController {

    @Autowired
    private coursService coursService;

    @RequestMapping("/modules/{id}/cours")
    public List<cours> getAllCours(@PathVariable Integer id) {
        return coursService.getAllCours(id);
    }

    @RequestMapping("/modules/{moduleId}/cours/{id}")
    public Optional<cours> getCours(@PathVariable Integer id) {
        return coursService.getCours(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modules/{moduleId}/cours")
    public void ajouterCours(@RequestBody cours cours, @PathVariable Integer moduleId) {
        cours.setModule(new Module(moduleId, "", ""));
        coursService.ajouterCours(cours);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modules/{moduleId}/cours/{id}")
    public void modifierCours(@RequestBody cours cours, @PathVariable Integer moduleId, @PathVariable Integer id) {
        cours.setModule(new Module(moduleId, "", ""));
        coursService.modifierCours(cours);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/modules/{moduleId}/cours/{id}")
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }
}