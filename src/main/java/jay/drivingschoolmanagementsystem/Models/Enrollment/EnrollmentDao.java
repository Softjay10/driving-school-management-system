package jay.drivingschoolmanagementsystem.Models.Enrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment, Long> {

    @Query(value = "SELECT COUNT(e.id) FROM Enrollment e")
    long countEnrollmentById();
}
