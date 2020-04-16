package lesson60.homework.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {
    List<Comment> getCommentsByPublicationId(String publicationId);
    List<Comment> findAll();
}