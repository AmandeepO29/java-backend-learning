package in.strikes.springDataJPADemo.repository;

import in.strikes.springDataJPADemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = """
                select * from student
                where email=:email
                """,nativeQuery = true)
    Optional<Student> findByEmail( @Param("email") String email);
}
