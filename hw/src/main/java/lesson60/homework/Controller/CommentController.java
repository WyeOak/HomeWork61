package lesson60.homework.Controller;

import lesson60.homework.Model.Comment;
import lesson60.homework.Model.CommentRepository;
import lesson60.homework.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    final private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getComments/{publicationId}")
    public List<Comment> getComments(@PathVariable("publicationId") String publicationId){
        return commentRepository.getCommentsByPublicationId(publicationId);
    }
}
