package jay.drivingschoolmanagementsystem.Controller;

import jay.drivingschoolmanagementsystem.Configuration.FileUploadUtil;
import jay.drivingschoolmanagementsystem.Models.Instructor.Instructor;
import jay.drivingschoolmanagementsystem.Models.Instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;


@Controller
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping(value = "/instructors")
    public String listIndex(Model model){
        //Account Status = active & not active
        model.addAttribute("instructors", instructorService.findAllInstructorSAccountStatus());
        model.addAttribute("instructorsList", instructorService.getAllInstructor());
        return "views/backend/instructor/index";
    }

    @GetMapping(value = "/add-instructor")
    public String getInstructorCreate(Model model, Instructor instructor) {
        model.addAttribute("instructors", instructor);
        return "views/backend/instructor/create";
    }

    @PostMapping("/create-instructor")
    public RedirectView save(@ModelAttribute("instructors") Instructor instructor,
                             @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        instructor.setPhoto(fileName);
        Instructor saveInstructor1 = instructorService.createInstructor(instructor);
        String uploadDir = "user-photos/" + saveInstructor1.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/instructors", true);
    }

    @GetMapping(value = "/edit-instructors/{id}")
    public String updateInstructor(@PathVariable(value = "id") Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructors", instructor);
        return "views/backend/instructor/update";
    }

    @RequestMapping(value = "/delete-instructors/{id}")
    public String deleteInstructor(@PathVariable(value = "id") Long id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructors";
    }

}
