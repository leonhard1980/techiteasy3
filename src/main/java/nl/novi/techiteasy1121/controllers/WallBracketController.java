package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WallBracketController {
    private final WallBracketRepository wallBracketRepository;

    @Autowired
    public WallBracketController(WallBracketRepository wallBracketRepository){
        this.wallBracketRepository = wallBracketRepository;
    }
}
