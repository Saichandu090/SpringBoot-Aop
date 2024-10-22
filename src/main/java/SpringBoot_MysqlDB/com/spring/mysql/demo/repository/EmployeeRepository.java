package SpringBoot_MysqlDB.com.spring.mysql.demo.repository;

import SpringBoot_MysqlDB.com.spring.mysql.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

}
