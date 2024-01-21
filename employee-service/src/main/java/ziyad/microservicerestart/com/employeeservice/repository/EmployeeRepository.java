package ziyad.microservicerestart.com.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ziyad.microservicerestart.com.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
