package jay.drivingschoolmanagementsystem.Controller;

import jay.drivingschoolmanagementsystem.Models.Enrollment.EnrollmentDao;
import jay.drivingschoolmanagementsystem.Models.Instructor.InstructorDao;
import jay.drivingschoolmanagementsystem.Models.Payment.PaymentDao;
import jay.drivingschoolmanagementsystem.Models.Student.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    InstructorDao instructorDao;

    @Autowired
    EnrollmentDao enrollmentDao;

    @Autowired
    PaymentDao paymentDao;


    @GetMapping(value = "/")
    public String getDashboard(Model model){
        model.addAttribute("students", studentDao.countStudentById());
        model.addAttribute("instructors", instructorDao.countInstructorById());
        model.addAttribute("enrollments", enrollmentDao.countEnrollmentById());
        model.addAttribute("payments", paymentDao.countPaymentById());
        return "views/backend/dashboard/index";
    }

    @GetMapping(value = "/login")
    public String getLogin(){
        return "views/frontend/login/index";
    }

    @GetMapping(value = "/registration")
    public String getRegistration() {
        return "views/frontend/student-registration/index";
    }

}
