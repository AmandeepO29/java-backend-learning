package in.strikes.transactionDemo.repository;

import in.strikes.transactionDemo.entity.Account;
import in.strikes.transactionDemo.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
