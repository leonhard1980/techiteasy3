package nl.novi.techiteasy1121.services;


import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteControllerService {

private final RemoteControllerRepository remoteControllerRepository;

public RemoteControllerService(RemoteControllerRepository remoteControllerRepository){
    this.remoteControllerRepository = remoteControllerRepository;
}


}
