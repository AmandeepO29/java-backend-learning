package in.strikes.jpaCascadingDemo.repository;

import in.strikes.jpaCascadingDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class,id);
    }

    // for the whole application , department and profile are lazily initialised ; but for
    // this method , we have to initialise them eagerly
    @EntityGraph(attributePaths = {"department","profile"})
    public List<Student> findAll(){

    }
}
