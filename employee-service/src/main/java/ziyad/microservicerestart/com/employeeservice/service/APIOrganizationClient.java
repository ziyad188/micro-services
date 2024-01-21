package ziyad.microservicerestart.com.employeeservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ziyad.microservicerestart.com.employeeservice.dto.OrganizationDto;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface APIOrganizationClient {
    @GetMapping("api/organizations/{id}")
    OrganizationDto getOrganization(@PathVariable("id") String organizationCode);
}
