package jay.drivingschoolmanagementsystem.Controller;

import jay.drivingschoolmanagementsystem.Models.Enrollment.Enrollment;
import jay.drivingschoolmanagementsystem.Models.Payment.Payment;
import jay.drivingschoolmanagementsystem.Models.Payment.PaymentService;
import jay.drivingschoolmanagementsystem.Models.Student.Student;
import jay.drivingschoolmanagementsystem.Models.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/payments")
    public String listPayment(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        model.addAttribute("students", studentService.getAllStudent());
        return "views/backend/payment/index";
    }

    @RequestMapping(value = "/payments/findById")
    @ResponseBody
    public Optional<Payment> findById(Long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping(value = "/payments/create")
    public String addPayment(Payment payment) {
        paymentService.createPayment(payment);
        return "redirect:/payments";
    }

    @RequestMapping(value = "/payments/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Payment payment) {
        paymentService.createPayment(payment);
        return "redirect:/payments";
    }

    @RequestMapping(value = "/payments/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }
}
