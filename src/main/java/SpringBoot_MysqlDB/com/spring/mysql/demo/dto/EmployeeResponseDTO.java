package SpringBoot_MysqlDB.com.spring.mysql.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO
{
    private String name;
    private String city;
}
