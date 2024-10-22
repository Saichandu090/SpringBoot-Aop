package SpringBoot_MysqlDB.com.spring.mysql.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO
{
    @Pattern(regexp = "^[A-Z][A-Z a-z]{2,}$")
    private String name;
    @NotBlank
    private String city;
    private double sal;
    @Pattern(regexp = "^[A-Z a-z]+$")
    private String maritalStatus;
}
