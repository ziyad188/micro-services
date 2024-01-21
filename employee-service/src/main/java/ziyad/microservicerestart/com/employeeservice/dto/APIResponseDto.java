package ziyad.microservicerestart.com.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    private Employeedto employeedto;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;

}
