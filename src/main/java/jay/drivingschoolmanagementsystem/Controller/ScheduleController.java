package jay.drivingschoolmanagementsystem.Controller;

import jay.drivingschoolmanagementsystem.Models.Instructor.InstructorService;
import jay.drivingschoolmanagementsystem.Models.Schedule.Schedule;
import jay.drivingschoolmanagementsystem.Models.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    InstructorService instructorService;


    @GetMapping(value = "/schedules")
    public String listSchedule(Model model){
        model.addAttribute("schedules",scheduleService.getAllSchedule());
        model.addAttribute("instructors", instructorService.getAllInstructor());
        return "views/backend/schedule/index";
    }

    @RequestMapping(value = "/edit-schedule")
    @ResponseBody
    public Optional<Schedule> findById(Long id){
        return scheduleService.getScheduleById(id);
    }

    @PostMapping(value = "/schedules/create")
    public String add(Schedule schedule) {
        scheduleService.save(schedule);
        return "redirect:/schedules";
    }

    @RequestMapping(value = "/schedules/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Schedule schedule) {
        scheduleService.save(schedule);
        return "redirect:/schedules";
    }

    @RequestMapping(value = "/schedules/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        scheduleService.deleteById(id);
        return "redirect:/schedules";
    }
}
