package lesson60.homework.Util;

import lesson60.homework.Model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabasePreloader {
    private static final Random r = new Random();
    private static final BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PublicationRepository publicationRepository,
                                   CommentRepository commentRepository) {
            userRepository.deleteAll();
            publicationRepository.deleteAll();
            commentRepository.deleteAll();

            return(args) -> save(userRepository, publicationRepository,commentRepository);
    }

    private void save(UserRepository userRepository, PublicationRepository publicationRepository, CommentRepository commentRepository){
        List<User> users = Arrays.asList(users());
        userRepository.saveAll(users);

        for(int i = 0; i < 3; i++){
            String username = users.get(r.nextInt(users.size())).getUsername();
            User user = userRepository.findByUsername(username).get();

            Publication p = new Publication(user, "/files/"+ images()[r.nextInt(images().length)] +".jpg",Generator.makeDescription());
            publicationRepository.save(p);

            Comment c = new Comment(user,p,"some comment");
            commentRepository.save(c);
        }
    }

    private User[] users() {
        return new User[]{
                new User("markus", crypt.encode("markus123")),
                new User("nikita", crypt.encode("nikita123")),
                new User("tawanna", crypt.encode("tawanna123")),
                new User("brunilda", crypt.encode("brunilda123")),
        };
    }

    private String[] images() {
        return new String[]{"lambo","porshe","retro_car"};
    }
}
