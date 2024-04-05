package lk.ijse.gdse66.springWeb.repositories;

import lk.ijse.gdse66.springWeb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
