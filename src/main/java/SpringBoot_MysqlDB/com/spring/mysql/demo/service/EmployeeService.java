package SpringBoot_MysqlDB.com.spring.mysql.demo.service;

import SpringBoot_MysqlDB.com.spring.mysql.demo.dto.EmployeeRequestDTO;
import SpringBoot_MysqlDB.com.spring.mysql.demo.dto.EmployeeResponseDTO;
import SpringBoot_MysqlDB.com.spring.mysql.demo.model.Employee;
import SpringBoot_MysqlDB.com.spring.mysql.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO)
    {
        Employee employee=new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setCity(employeeRequestDTO.getCity());
        employee.setSal(employeeRequestDTO.getSal());
        employee.setMaritalStatus(employeeRequestDTO.getMaritalStatus());
        return employeeToResponseDTO(employeeRepository.save(employee));
    }

    private EmployeeResponseDTO employeeToResponseDTO(Employee employee)
    {
        EmployeeResponseDTO employeeResponseDTO=new EmployeeResponseDTO();
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setCity(employee.getCity());
        return employeeResponseDTO;
    }

    public EmployeeResponseDTO findById(int usn)
    {
        Employee employee=employeeRepository.findById(usn).orElseThrow(()->new RuntimeException("Employee not found!!"));
        return employeeToResponseDTO(employee);
    }

    public List<EmployeeResponseDTO> getAllEmployees()
    {
        List<Employee> list=employeeRepository.findAll();
        List<EmployeeResponseDTO> responseDTOS=new ArrayList<>();
        for(Employee e : list)
        {
             responseDTOS.add(employeeToResponseDTO(e));
        }
        return responseDTOS;
    }
}
