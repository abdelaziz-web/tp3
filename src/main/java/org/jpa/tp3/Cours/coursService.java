package org.jpa.tp3.Cours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class coursService {


    @Autowired
    private coursRepository coursRepository;

    public List<cours> getAllCours(Integer moduleId) {
        List<cours> cours=new ArrayList<>();
        coursRepository.findByModuleId(moduleId).forEach(cours::add);
        return cours;
    }
    public Optional<cours> getCours(Integer id) {
        return coursRepository.findById(id);
    }
    public void ajouterCours(cours cours) {
        coursRepository.save(cours); //la méthode save est implémentée dans CourseRepository
    }
    public void modifierCours(cours cours) {
        coursRepository.save(cours); //ici save dans le rôle de la mise à jour
    }
    public void supprimerCours(Integer id) {
        coursRepository.deleteById(id);
    }







}
