package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.Dtos.RemoteControllerDTO;
import nl.novi.techiteasy1121.Dtos.RemoteControllerInputDTO;
import nl.novi.techiteasy1121.services.RemoteControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RemoteControllerController {

private final RemoteControllerService remoteControllerService;

    @Autowired
    public RemoteControllerController(RemoteControllerService remoteControllerService){
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping("/remotecontroller")
    public ResponseEntity<List<RemoteControllerDTO>> getAllRemoteControllers(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<RemoteControllerDTO> dtos;

        if (brand.isEmpty()){
            dtos = remoteControllerService.getAllRemoteControllers();
        } else {
            dtos = remoteControllerService.getAllRemoteControllersByBrand(brand.get());
        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("/remoteControllers/{id}")
    public ResponseEntity<RemoteControllerDTO> getAllRemoteControllers(@PathVariable("id")Long id) {

        RemoteControllerDTO remoteController = remoteControllerService.getRemoteControllerById(id);
        return ResponseEntity.ok().body(remoteController);

    }

    @PostMapping("/remotecontrollers")
    public ResponseEntity<Object> addRemoteControllers(@RequestBody RemoteControllerInputDTO remoteControllerInputDto) {
        RemoteControllerDTO dto = remoteControllerService.addRemoteController(remoteControllerInputDto);
        return ResponseEntity.created(null).body(dto);

    }

    @DeleteMapping("/remotecontrollers/{id}")
    public ResponseEntity<Object> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/remotecontrollers/{id}")
    public ResponseEntity<Object> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDTO newRemoteController) {

        RemoteControllerDTO dto = remoteControllerService.updateRemoteController(id, newRemoteController);

        return ResponseEntity.ok().body(dto);
    }


}
