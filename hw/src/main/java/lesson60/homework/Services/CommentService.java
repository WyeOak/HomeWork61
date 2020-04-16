package lesson60.homework.Services;

import lesson60.homework.Model.CommentRepository;
import lesson60.homework.Model.PublicationRepository;
import lesson60.homework.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PublicationRepository publicationRepository;
}

