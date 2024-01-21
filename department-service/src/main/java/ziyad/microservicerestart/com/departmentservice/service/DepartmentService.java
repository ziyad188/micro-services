package ziyad.microservicerestart.com.departmentservice.service;

import ziyad.microservicerestart.com.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(String departmentCode);
}
