package lk.ijse.gdse66.springWeb.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String cusId;
    private String cusName;
    private String cusAddress;
    private double cusSalary;
}
