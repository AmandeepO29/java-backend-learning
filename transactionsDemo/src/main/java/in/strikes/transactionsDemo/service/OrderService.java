package in.strikes.transactionsDemo.service;

import in.strikes.transactionsDemo.entity.Order;
import in.strikes.transactionsDemo.repository.OrderRepository;
import in.strikes.transactionsDemo.repository.PaymentAuditRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private PaymentAuditService paymentAuditService;

    public OrderService(OrderRepository orderRepository,
                        PaymentAuditService paymentAuditService) {
        this.orderRepository = orderRepository;
        this.paymentAuditService=paymentAuditService;
    }

    @Transactional
    public void placeOrder(Order order) {
        orderRepository.save(order);
        paymentAuditService.audit(order);
    }
}
