package lk.ijse.gdse66.springWeb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDTO {

    @Null(message = "id is auto generated")
    private String cusId;
    @Pattern(regexp = "[A-Za-z ]+", message = "the name is not valid")
    @NotBlank(message = "name can not be null")
    private String cusName;
    @NotBlank(message = "address can not be null")
    private String cusAddress;
    /*@NotBlank(message = "salary can not be null")*/
    private double cusSalary;
}
