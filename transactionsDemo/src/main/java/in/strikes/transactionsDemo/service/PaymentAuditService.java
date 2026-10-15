package in.strikes.transactionsDemo.service;

import in.strikes.transactionsDemo.entity.Order;
import in.strikes.transactionsDemo.entity.PaymentAudit;
import in.strikes.transactionsDemo.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    public PaymentAuditService() {
    }


    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT
    )
    public void audit(Order order) {
        PaymentAudit paymentAudit=new PaymentAudit(
                order.getAmount(), order.getId(), true
        );
        paymentAuditRepository.save(paymentAudit);
//        try{
//            throw new RuntimeException();
//        }
//        catch (Exception e){
//
//        }


    }
}
