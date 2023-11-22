package jay.drivingschoolmanagementsystem.Controller;

import jay.drivingschoolmanagementsystem.Models.Student.Student;
import jay.drivingschoolmanagementsystem.Models.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public String getStudentAll(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "views/backend/student/index";
    }

    @RequestMapping(value = "/students/findById")
    @ResponseBody
    public Optional<Student> findById(Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping(value = "/students/create")
    public String addStudent(Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
