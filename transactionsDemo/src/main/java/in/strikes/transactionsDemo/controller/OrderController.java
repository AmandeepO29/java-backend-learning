package in.strikes.transactionsDemo.controller;

import in.strikes.transactionsDemo.entity.Order;
import in.strikes.transactionsDemo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService ordeService;

    public OrderController(OrderService ordeService) {
        this.ordeService = ordeService;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        ordeService.placeOrder(order);
        return ResponseEntity.ok("DONE");
    }
}
