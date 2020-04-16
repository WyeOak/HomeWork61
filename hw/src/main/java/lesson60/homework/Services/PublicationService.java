package lesson60.homework.Services;

import lesson60.homework.Model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final PublicationRepository publicationRepository;

    public PublicationService(UserRepository userRepository, SubscriptionRepository subscriptionRepository,
                              PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.publicationRepository = publicationRepository;
    }

    public Set<Publication> getPublications(String userId){
        List<Subscription> followed = subscriptionRepository.getAllByFollowerId(userId);
        List<String> followed_ids = followed.stream().map(f -> f.getFollowed().getId()).collect(Collectors.toList());
        return publicationRepository.getPublicationByUserIdIn(followed_ids);
    }


}