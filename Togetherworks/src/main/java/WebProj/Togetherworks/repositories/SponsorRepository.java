package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {
    Optional<Sponsor> findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
