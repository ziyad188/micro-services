package ziyad.microservicerestart.com.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ziyad.microservicerestart.com.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIDepartmentClient {
    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartment(@PathVariable("id") String code);
}
