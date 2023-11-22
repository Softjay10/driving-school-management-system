package jay.drivingschoolmanagementsystem.Controller;

import jay.drivingschoolmanagementsystem.Models.Enrollment.Enrollment;
import jay.drivingschoolmanagementsystem.Models.Enrollment.EnrollmentService;
import jay.drivingschoolmanagementsystem.Models.Instructor.InstructorService;
import jay.drivingschoolmanagementsystem.Models.Schedule.ScheduleService;
import jay.drivingschoolmanagementsystem.Models.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EnrollmentController {

    @Autowired private EnrollmentService enrollmentService;

    @Autowired private ScheduleService scheduleService;

    @Autowired private StudentService studentService;

    @Autowired private InstructorService instructorService;

    @GetMapping(value = "/enrollments")
    public String getStudentAll(Model model){
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());
        model.addAttribute("schedules", scheduleService.getAllSchedule());
        model.addAttribute("students", studentService.getAllStudent());
        model.addAttribute("instructors", instructorService.getAllInstructor());
        return "views/backend/enrollment/index";
    }

    @RequestMapping(value = "/enrollments/findById")
    @ResponseBody
    public Optional<Enrollment> findById(Long id){
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping(value = "/enrollments/create")
    public String add(Enrollment enrollment) {
        enrollmentService.createEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    @RequestMapping(value = "/enrollments/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Enrollment enrollment) {
        enrollmentService.createEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    @RequestMapping(value = "/enrollments/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        enrollmentService.deleteEnrollmentById(id);
        return "redirect:/enrollments";
    }

}
