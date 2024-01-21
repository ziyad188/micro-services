package ziyad.microservicerestart.com.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ziyad.microservicerestart.com.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String departmentCode);


}
