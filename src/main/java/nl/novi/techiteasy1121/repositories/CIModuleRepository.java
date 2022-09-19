package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.CIModule;
import nl.novi.techiteasy1121.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {

    List<CIModule> findAllCIModulesByBrandEqualsIgnoreCase(String brand);

}
