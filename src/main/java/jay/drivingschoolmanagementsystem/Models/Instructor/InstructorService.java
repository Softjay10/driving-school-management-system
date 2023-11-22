package jay.drivingschoolmanagementsystem.Models.Instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorDao instructorDao;

    public List<Instructor> getAllInstructor(){
        return instructorDao.findAll();
    }

    /*ACCOUNT STATUS*/
    public List<Instructor> findAllInstructorSAccountStatus(){
        return instructorDao.getInstructorByAccountStatus();
    }

    /*GET BY ID*/
    public Instructor getInstructorById(Long id){
        Optional<Instructor> optionalInstructor = instructorDao.findById(id);
        return optionalInstructor.get();
    }

    /*SAVE*/
    public Instructor createInstructor(Instructor instructor) {
        return instructorDao.save(instructor);
    }

    /*DELETE*/
    public void deleteInstructor(Long id){
        instructorDao.deleteById(id);
    }


    /*UPDATE*/
    public Instructor updateInstructor(Instructor instructor) {
        Instructor existingInstructor = instructorDao.findById(instructor.getId()).get();
        existingInstructor.setInstructorName(instructor.getInstructorName());
        existingInstructor.setContact(instructor.getContact());
        existingInstructor.setEmail(instructor.getEmail());
        existingInstructor.setGender(instructor.getGender());
        existingInstructor.setBirthDate(instructor.getBirthDate());
        existingInstructor.setDrivingExperience(instructor.getDrivingExperience());
        existingInstructor.setAccountStatus(instructor.getAccountStatus());
        existingInstructor.setPhoto(instructor.getPhoto());
        Instructor updatedInstructor = instructorDao.save(existingInstructor);
        return updatedInstructor;
    }


}
