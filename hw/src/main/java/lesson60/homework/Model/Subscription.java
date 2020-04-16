package lesson60.homework.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "subscriptions")
@CompoundIndex(def = "{'followed':1, 'follower':1}")
public class Subscription {
    @Id
    private String id;

    @DBRef
    private User followed;
    @DBRef
    private User follower;
    private LocalDate dayOfSubscription;


    public Subscription(User followed, User follower) {
        this.followed = followed;
        this.follower = follower;
        dayOfSubscription = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public LocalDate getDayOfSubscription() {
        return dayOfSubscription;
    }

    public void setDayOfSubscription(LocalDate dayOfSubscription) {
        this.dayOfSubscription = dayOfSubscription;
    }
}