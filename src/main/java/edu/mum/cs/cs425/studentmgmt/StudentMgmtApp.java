package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.Model.Classroom;
import edu.mum.cs.cs425.studentmgmt.Model.Student;
import edu.mum.cs.cs425.studentmgmt.Model.Transcript;
import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMgmtApp {

    @PersistenceContext(unitName = "studentmgmt")
    private EntityManager entityManager;

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentmgmt");

    public static void main(String[] args) {
        try {
//            Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, sdf.parse("2019/05/24"));
//            saveStudent(s1);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Transcript transcript = new Transcript("BS Computer Science");
            Classroom classroom = new Classroom("McLaughlin building", "M105");
            Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, sdf.parse("2019/05/24"), transcript, classroom);

            saveStudent(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
