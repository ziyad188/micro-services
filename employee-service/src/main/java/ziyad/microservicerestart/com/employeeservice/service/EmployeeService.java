package ziyad.microservicerestart.com.employeeservice.service;

import ziyad.microservicerestart.com.employeeservice.dto.APIResponseDto;
import ziyad.microservicerestart.com.employeeservice.dto.Employeedto;

public interface EmployeeService {
    Employeedto saveEmployee(Employeedto employeedto);
    APIResponseDto getEmployee(Long employeeId);
}
