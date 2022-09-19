package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.Dtos.TelevisionDto;
import nl.novi.techiteasy1121.Dtos.TelevisionInputDto;
import nl.novi.techiteasy1121.Dtos.WallBracketDTO;
import nl.novi.techiteasy1121.Dtos.WallBracketInputDTO;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WallBracketController {

private final WallBracketService wallBracketService;

@Autowired
    public WallBracketController(WallBracketService wallBracketService){
    this.wallBracketService = wallBracketService;
}

@GetMapping("/wallbrackets")
    public ResponseEntity<List<WallBracketDTO>> getAllWallBrackets(@RequestParam(value = "name", required = false)Optional<String> name){
    List<WallBracketDTO> dtos;
    if (name.isEmpty()){

        dtos = wallBracketService.getAllWallBrackets();
    } else {
        dtos = wallBracketService.getAllWallBracketsByBrand(name.get());
    }

    return ResponseEntity.ok().body(dtos);
}

    @GetMapping("/wallbrackets/{id}")
    public ResponseEntity<WallBracketDTO> getWallBrackets(@PathVariable("id")Long id) {

        WallBracketDTO wallBracket = WallBracketService.getWallBracketById(id);

        return ResponseEntity.ok().body(wallBracket);
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<Object> addWallBracket(@RequestBody WallBracketInputDTO wallBracketInputDTO) {

        WallBracketDTO dto = wallBracketService.addWallBracket(wallBracketInputDTO);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/wallbrackets/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable Long id) {

        wallBracketService.deleteWallBracket(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/wallbrackets/{id}")
    public ResponseEntity<Object> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDTO newWallBracket) {

        WallBracketDTO dto = wallBracketService.updateWallBracket(id, newWallBracket);

        return ResponseEntity.ok().body(dto);
    }


}
