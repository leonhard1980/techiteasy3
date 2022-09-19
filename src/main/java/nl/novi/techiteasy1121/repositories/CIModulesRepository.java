package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CIModulesRepository extends JpaRepository<CIModule, Long> {
    List<CIModule> findAllCIModulesByBrandEqualsIgnoreCase(String name);

}
