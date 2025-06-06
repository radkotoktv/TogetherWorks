package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import WebProj.Togetherworks.enums.Type;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Optional<Resource> findByType(Type type);

    boolean existsByType(Type type);

    void deleteByType(Type type);
}
