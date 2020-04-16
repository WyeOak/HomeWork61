package lesson60.homework.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription,String> {
    List<Subscription> getAllByFollowerId(String followerId);
}