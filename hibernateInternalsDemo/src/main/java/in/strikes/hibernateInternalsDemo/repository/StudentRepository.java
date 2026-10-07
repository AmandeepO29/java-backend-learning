package in.strikes.hibernateInternalsDemo.repository;

import in.strikes.hibernateInternalsDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

    public Student findById(Long id){
        // yha 2 baar query run nhi hogi kyonki dusri baar persistence context se extract hogaaa
        Student s1=entityManager.find(Student.class,id);
        Student s2= entityManager.find(Student.class,id);
        return s2;
    }

    public void remove(Student student){
        entityManager.remove(student);
    }

    public void flush() {
        entityManager.flush();
    }

    public void detach(Student student){
        entityManager.detach(student);
    }

    public void merge(Student student){
        entityManager.merge(student);
    }

    public void persist(Student student){
        entityManager.persist(student);
    }

    public void saveAll(List<Student> students){
        int counter=0;
        for(Student student:students){
            entityManager.persist(student);
            counter++;
            if(counter%100==0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
