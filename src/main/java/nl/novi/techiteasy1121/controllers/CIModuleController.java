package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.models.CIModule;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.CIModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CIModuleController {

private final CIModuleRepository ciModuleRepository;

@Autowired
    public CIModuleController(CIModuleRepository ciModuleRepository){
    this.ciModuleRepository = ciModuleRepository;
}

/*    @GetMapping("/cimodules")
    public ResponseEntity<List<CIModule>> getAllCIModules(@RequestParam(value = "brand", required = false) String brand) {

        List<CIModule> cimodules;

        if (brand == null){
            cimodules = CIModuleRepository.findAll();
            return ResponseEntity.ok().body(cimodules);
        } else {
            cimodules = CIModuleRepository.findAllCIModulesByBrandEqualsIgnoreCase(brand);
        }
        return ResponseEntity.ok().body(cimodules);

    }*/

}
