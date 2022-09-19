package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteControllerController {

    final private RemoteControllerRepository remoteControllerRepository;

    @Autowired
    public RemoteControllerController(RemoteControllerRepository remoteControllerRepository){
        this.remoteControllerRepository = remoteControllerRepository;
    }

}
