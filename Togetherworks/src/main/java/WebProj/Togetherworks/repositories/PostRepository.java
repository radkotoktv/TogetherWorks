package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query(value = "DELETE FROM Post p WHERE p.idpost=?1")
    public Post deleteById(int id);
    @Query(value = "SELECT p FROM Post p WHERE p.idpost=?1")
    public Post getById(int id);

}
