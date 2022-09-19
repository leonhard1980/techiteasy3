package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.RemoteController;
import nl.novi.techiteasy1121.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemoteControllerRepository extends JpaRepository<RemoteController, Long> {

    List<RemoteController> findAllRemoteControllersByBrandEqualsIgnoreCase(String brand);

}
