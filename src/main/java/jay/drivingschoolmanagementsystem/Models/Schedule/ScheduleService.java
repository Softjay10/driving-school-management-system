package jay.drivingschoolmanagementsystem.Models.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    public List<Schedule> getAllSchedule(){
        return scheduleDao.findAll();
    }

    //Get By Id
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleDao.findById(id);
    }

    //Delete Student
    public void deleteById(Long id) {
        scheduleDao.deleteById(id);
    }

    //Update Student
    public void save(Schedule schedule) {
        scheduleDao.save(schedule);
    }
}
