package lesson60.homework.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "comments")
public class Comment {

    @Id
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;
    @DBRef
    private Publication publication;

    private String text;
    private LocalDateTime timeOfComment;


    public Comment(User user, Publication publication, String text) {
        this.user = user;
        this.publication = publication;
        this.text = text;
        timeOfComment = LocalDateTime.now();
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimeOfComment() {
        return timeOfComment;
    }

    public void setTimeOfComment(LocalDateTime timeOfComment) {
        this.timeOfComment = timeOfComment;
    }
}
