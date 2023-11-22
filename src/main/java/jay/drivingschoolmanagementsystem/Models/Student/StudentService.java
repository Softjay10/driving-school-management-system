package jay.drivingschoolmanagementsystem.Models.Student;

import jay.drivingschoolmanagementsystem.Models.Schedule.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentDao.findById(id);
    }

    public void delete(Long id){
        studentDao.deleteById(id);
    }

    public void create(Student student){
        studentDao.save(student);
    }
}
