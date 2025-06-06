package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
