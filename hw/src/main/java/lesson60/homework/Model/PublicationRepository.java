package lesson60.homework.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PublicationRepository extends CrudRepository<Publication,String> {
    List<Publication> findAll();
    Publication findPublicationById(String id);

    List<Publication> getPublicationsByUserId(String userId);

    List<Publication> getPublicationsByUserIdNot(String userId);
    Set<Publication> getPublicationByUserIdIn(List<String> idList);

    Publication getPublicationByUserId(String userId);
}