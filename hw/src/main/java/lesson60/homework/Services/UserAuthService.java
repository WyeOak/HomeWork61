package lesson60.homework.Services;

import lesson60.homework.Model.Publication;
import lesson60.homework.Model.PublicationRepository;
import lesson60.homework.Model.User;
import lesson60.homework.Model.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private PublicationRepository publicationRepository;
    private static final BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = repo.findByUsername(s);
        if (user.isPresent())
            return user.get();

        throw new UsernameNotFoundException("User does not exit");
    }

    public User addUser(User user){
        String password = user.getPassword();
        user.setPassword(crypt.encode(password));
        repo.save(user);
        return user;
    }

    public User getByUsername(String username){
        return repo.findByUsername(username).get();
    }

    public User getByEmail(String email){
        return repo.findByEmail(email);
    }

    public User getByName(String name){return repo.findByName(name);}

    public List<Publication> getPublicationsByUserId(String userId){
        return publicationRepository.getPublicationsByUserId(userId);
    }

    public User getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return repo.findByUsername(auth.getName()).get();
    }
}
