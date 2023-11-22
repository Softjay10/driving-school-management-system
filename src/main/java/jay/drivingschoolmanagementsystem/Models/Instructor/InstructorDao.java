package jay.drivingschoolmanagementsystem.Models.Instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDao extends JpaRepository<Instructor, Long> {

    @Query(value = "select i from Instructor i where i.accountStatus = 'active' or i.accountStatus = 'not active'")
    List<Instructor> getInstructorByAccountStatus();

    @Query(value = "SELECT COUNT(i.id) FROM Instructor i")
    long countInstructorById();
}
