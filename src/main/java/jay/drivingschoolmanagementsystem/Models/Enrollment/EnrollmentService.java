package jay.drivingschoolmanagementsystem.Models.Enrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentDao.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id){
        return enrollmentDao.findById(id);
    }

    public void createEnrollment(Enrollment enrollment) {
        enrollmentDao.save(enrollment);
    }

    public void deleteEnrollmentById(Long id){
        enrollmentDao.deleteById(id);
    }

}
