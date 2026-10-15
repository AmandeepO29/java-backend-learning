package in.strikes.transactionsDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class PaymentAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private Long orderId;

    private boolean paymentSuccess;

    public PaymentAudit(BigDecimal amount, Long orderId, boolean paymentSuccess) {
        this.amount = amount;
        this.orderId = orderId;
        this.paymentSuccess = paymentSuccess;
    }
}
