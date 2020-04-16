package lesson60.homework.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "likes")
public class Like {

    @Id
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;
    @DBRef
    private Publication publication;

    private LocalDateTime timeOfLike;

    public Like(User user, Publication publication) {
        this.user = user;
        this.publication = publication;
        timeOfLike = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public LocalDateTime getTimeOfLike() {
        return timeOfLike;
    }

    public void setTimeOfLike(LocalDateTime timeOfLike) {
        this.timeOfLike = timeOfLike;
    }
}