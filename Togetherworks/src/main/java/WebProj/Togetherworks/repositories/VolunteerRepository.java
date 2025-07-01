package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
    @Query(value="SELECT v FROM Volunteer v WHERE v.first_name LIKE ?1 AND v.last_name LIKE ?2")
    Optional<Volunteer> findByName(String fname, String lname);

    @Query("SELECT v FROM Volunteer v WHERE v.username = ?1")
    Optional<Volunteer> findByUsername(String username);

    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM Volunteer v WHERE v.username = ?1 OR v.email = ?2")
    boolean existsByUsernameOrEmail(String username, String email);

    @Query(value="SELECT v FROM Volunteer v WHERE v.first_name LIKE ?1 AND v.last_name LIKE ?2")
    boolean existsByName(String fname,String lname);

    @Modifying
    @Query(value="DELETE  FROM Volunteer v WHERE v.first_name LIKE ?1 AND v.last_name LIKE ?2")
    void deleteByName(String fname, String lname);


}
