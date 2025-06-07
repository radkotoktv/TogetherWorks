package WebProj.Togetherworks.repositories;

import WebProj.Togetherworks.models.Comment;
import WebProj.Togetherworks.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(value = "SELECT c FROM Comment c WHERE c.idcomment=?1")
    public Comment getById(int id);
    @Query(value = "DELETE FROM Comment c WHERE c.idcomment = ?1 ")
    public Comment deleteById(int id);
    @Query(value = "SELECT c FROM Comment c WHERE c.post.idpost = ?1 AND c.parent.idcomment IS NULL")
    public List<Comment> getFirstLevelCommentsOfPost(int id);
    @Query(value = "SELECT c.post FROM Comment c WHERE c.idcomment = ?1")
    public Post getPostByCommentId(int id);
    @Query(value = "SELECT c.parent FROM Comment c WHERE c.idcomment = ?1")
    public Comment getParentByCommentId(int id);
    @Query(value = "SELECT c.idcomment FROM Comment c WHERE c.parent.idcomment = ?1")
    public List<Integer> getChildren(int id);
}
