package in.strikes.jpaCascadingDemo.repository;

import in.strikes.jpaCascadingDemo.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Profile profile) {
        entityManager.persist(profile);
    }

}
