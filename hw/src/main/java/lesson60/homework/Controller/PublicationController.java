package lesson60.homework.Controller;


import lesson60.homework.Model.Publication;
import lesson60.homework.Model.PublicationRepository;
import lesson60.homework.Services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController
public class PublicationController {
    @Autowired
    PublicationRepository publicationRepository;

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/getPosts")
    public List<Publication> getPosts(){
        return publicationRepository.findAll();
    }

    @GetMapping("/subscription_publications/{userId}")
    public List<Publication> findPublicationsOfOtherUsers(@PathVariable("userId") String userId){
        return publicationRepository.getPublicationsByUserIdNot(userId);
    }

    @GetMapping("/publications_of_subscriptions/{userId}")
    public Set<Publication> findPublicationsOfMySubscriptions(@PathVariable("userId") String userId){
        return publicationService.getPublications(userId);
    }
}