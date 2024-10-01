package org.jpa.tp3.Modules ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/modules")
    public List<Module> getModules() {
        return moduleService.getModules();
    }

    @RequestMapping("/modules/{id}")
    public Optional<Module> getModule(@PathVariable Integer id){
        return moduleService.getModule(id);
    }

    @PostMapping("/modules")
    public ResponseEntity<Module> ajouterModule(@RequestBody Module module) {
        moduleService.ajouterModule(module);
        return ResponseEntity.ok(module);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/modules/{id}")
    public void modifierModule(@RequestBody Module module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
    }

}
