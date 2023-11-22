package jay.drivingschoolmanagementsystem.Models.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    @Query(value = "SELECT COUNT(s.id) FROM Student s")
    long countStudentById();
}
