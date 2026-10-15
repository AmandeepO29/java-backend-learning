package in.strikes.transactionsDemo.repository;

import in.strikes.transactionsDemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public interface OrderRepository extends JpaRepository<Order,Long> {

}
