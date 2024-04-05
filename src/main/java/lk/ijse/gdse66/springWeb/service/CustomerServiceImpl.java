package lk.ijse.gdse66.springWeb.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.springWeb.dto.CustomerDTO;
import lk.ijse.gdse66.springWeb.repositories.CustomerRepo;
import lk.ijse.gdse66.springWeb.service.exception.NotFoundException;
import lk.ijse.gdse66.springWeb.service.util.Transformer;
import lk.ijse.gdse66.springWeb.service.util.UtilMatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    Transformer transformer;

    @Override
    public List<CustomerDTO> getAllCustomer() {

        return customerRepo.findAll().stream().map(customer -> transformer.fromCustomerEntity(customer)).toList();
    }

    @Override
    public CustomerDTO getCustomerDetail(String cusId) {
        if (!customerRepo.existsById(cusId)){
            throw new NotFoundException("customer id: "+cusId + "does not exits");
        }
        return transformer.fromCustomerEntity(customerRepo.findById(cusId).get());
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCusId(UtilMatter.generateId());
        return transformer.fromCustomerEntity(customerRepo.save(transformer.toCustomerEntity(customerDTO)));

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCusId())){
            throw new NotFoundException("update failed! customerId : "+ customerDTO.getCusId());
        }
        customerRepo.save(transformer.toCustomerEntity(customerDTO));
    }

    @Override
    public void deleteCustomer(String cusId) {
        if (!customerRepo.existsById(cusId)){
            throw new NotFoundException("delete failed! customerId : "+ cusId + "does not exist");
        }
    }
}
