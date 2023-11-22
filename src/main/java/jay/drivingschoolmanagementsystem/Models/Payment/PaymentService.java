package jay.drivingschoolmanagementsystem.Models.Payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public List<Payment> getAllPayments() {
        return paymentDao.findAll();
    }

   public Optional<Payment> getPaymentById(Long id) {
        return paymentDao.findById(id);
   }

    public void createPayment(Payment payment) {
        paymentDao.save(payment);
    }

    public void deletePayment(Long id){
        paymentDao.deleteById(id);
    }
}
