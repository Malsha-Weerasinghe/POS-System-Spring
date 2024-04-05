package lk.ijse.gdse66.springWeb.service.util;

import lk.ijse.gdse66.springWeb.dto.CustomerDTO;
import lk.ijse.gdse66.springWeb.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    @Autowired
    ModelMapper mapper;

    public CustomerDTO fromCustomerEntity(Customer customer){
        CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public Customer toCustomerEntity(CustomerDTO customerDTO){
        Customer customer = mapper.map(customerDTO, Customer.class);
        return customer;
    }
}
