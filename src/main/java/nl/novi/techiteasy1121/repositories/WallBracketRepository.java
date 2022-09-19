package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.models.WallBracket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WallBracketRepository extends JpaRepository<WallBracket, Long> {
    List<WallBracket> findAllWallBracketsByNameEqualsIgnoreCase(String name);
}