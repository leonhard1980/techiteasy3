package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.Dtos.CIModulesDTO;
import nl.novi.techiteasy1121.Dtos.CIModulesInputDTO;
import nl.novi.techiteasy1121.services.CIModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CIModuleController {

private final CIModuleService ciModuleService;

    @Autowired
    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping("/cimodule")
    public ResponseEntity<List<CIModulesDTO>> getAllCIModules(@RequestParam(value = "name", required = false) Optional<String> name) {
        List<CIModulesDTO> dtos;

        if (name.isEmpty()){

            dtos = ciModuleService.getAllCIModules();

        } else {
            dtos = ciModuleService.getAllCIModulesByName(name.get());
        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("/cimodules/{id}")
    public ResponseEntity<CIModulesDTO> getCimodule(@PathVariable("id")Long id) {

        CIModulesDTO ciModules = ciModuleService.getCIModuleById(id);

        return ResponseEntity.ok().body(ciModules);

    }

    @PostMapping("/cimodules")
    public ResponseEntity<Object> addCIModule(@RequestBody CIModulesInputDTO ciModulesInputDTO) {

        CIModulesDTO dto = ciModuleService.addCIModule(CIModulesInputDTO);

        return ResponseEntity.created(null).body(dto);

    }

    @DeleteMapping("/cimodules/{id}")
    public ResponseEntity<Object> deleteCIModules(@PathVariable Long id) {

        ciModuleService.deleteCIModule(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/cimodules/{id}")
    public ResponseEntity<Object> updateCIModule(@PathVariable Long id, @RequestBody CIModulesInputDTO newCIModule) {

        CIModulesDTO dto = ciModuleService.updateCIModule(id, newCIModule);

        return ResponseEntity.ok().body(dto);
    }



}
