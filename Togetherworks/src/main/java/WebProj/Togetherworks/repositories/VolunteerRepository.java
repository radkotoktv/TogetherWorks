package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
    @Query(value="SELECT v FROM Volunteer v WHERE v.first_name LIKE ?1 AND v.last_name LIKE ?2")
    Optional<Volunteer> findByName(String fname, String lname);

    @Query(value="SELECT v FROM Volunteer v WHERE v.first_name LIKE ?1 AND v.last_name LIKE ?2")
    boolean existsByName(String fname,String lname); // change this

    @Query(value="DELETE  FROM Volunteer v WHERE v.first_name LIKE ?1 AND v.last_name LIKE ?2")
    void deleteByName(String fname, String lname);
}
