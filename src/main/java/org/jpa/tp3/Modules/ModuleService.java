package org.jpa.tp3.Modules ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {



    @Autowired
    private ModuleRepository moduleRepository;

    public ModuleService() {
    }

    public List<Module> getModules() {
        List<Module> modules= new ArrayList<>();
        moduleRepository.findAll().forEach(m->modules.add(m));

        return modules;
    }

    public Optional<Module> getModule(Integer id) {
        return moduleRepository.findById(id);

    }

    public void ajouterModule(Module module) {
        moduleRepository.save(module);
    }

    public void modifierModule(Integer id, Module module) {
        moduleRepository.save(module);
    }

    public void supprimerModule(Integer id) {
            moduleRepository.deleteById(id);
    }
}