package lesson60.homework.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "publications")
public class Publication {

    @Id
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;

    private String img;
    private String description;
    private LocalDateTime timeOfPublication;

    public Publication(User user, String img, String description) {
        this.user = user;
        this.img = img;
        this.description = description;
        timeOfPublication = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimeOfPublication() {
        return timeOfPublication;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTimeOfPublication(LocalDateTime timeOfPublication) {
        this.timeOfPublication = timeOfPublication;
    }
}