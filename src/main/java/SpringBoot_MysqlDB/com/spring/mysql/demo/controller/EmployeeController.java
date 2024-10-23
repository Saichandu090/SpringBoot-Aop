package SpringBoot_MysqlDB.com.spring.mysql.demo.controller;

import SpringBoot_MysqlDB.com.spring.mysql.demo.dto.EmployeeRequestDTO;
import SpringBoot_MysqlDB.com.spring.mysql.demo.dto.EmployeeResponseDTO;
import SpringBoot_MysqlDB.com.spring.mysql.demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController
{
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmp")
    public ResponseEntity<EmployeeResponseDTO> addEmp(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO)
    {
        return new ResponseEntity<EmployeeResponseDTO>(service.addEmployee(employeeRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/*")
    public List<EmployeeResponseDTO> findAll()
    {
        return service.getAllEmployees();
    }

    @GetMapping("/byId/{usn}")
    public EmployeeResponseDTO findById(@PathVariable int usn)
    {
        return service.findById(usn);
    }
}
