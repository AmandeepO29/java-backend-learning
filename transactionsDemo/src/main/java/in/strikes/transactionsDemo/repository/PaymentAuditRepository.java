package in.strikes.transactionsDemo.repository;

import in.strikes.transactionsDemo.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit ,Long> {
}
