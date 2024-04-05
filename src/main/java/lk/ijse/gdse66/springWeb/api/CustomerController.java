package lk.ijse.gdse66.springWeb.api;

import jakarta.validation.Valid;
import lk.ijse.gdse66.springWeb.dto.CustomerDTO;
import lk.ijse.gdse66.springWeb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO saveCustomer(@Valid @RequestPart("cusId") String cusId, @RequestPart("cusName") String cusName, @RequestPart("cusAddress") String cusAddress, @RequestPart("cusSalary") double cusSalary){

        CustomerDTO customer = new CustomerDTO(cusId,cusName,cusAddress,cusSalary);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{cusId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("cusId") String cusId){
        customerService.deleteCustomer(cusId);
    }

    @PatchMapping(value = "/{cusId}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("cusId") String cusId,@Valid @RequestBody CustomerDTO customerDTO){
        customerDTO.setCusId(cusId);
        customerService.updateCustomer(customerDTO);

    }


    public CustomerDTO getCustomerDetail(@PathVariable("cusId") String cusId){
        return customerService.getCustomerDetail(cusId);

    }
}
