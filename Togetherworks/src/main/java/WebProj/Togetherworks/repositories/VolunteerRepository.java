package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
    Optional<Volunteer> findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
