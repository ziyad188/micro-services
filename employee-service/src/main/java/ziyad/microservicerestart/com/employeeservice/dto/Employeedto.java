package ziyad.microservicerestart.com.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description = "EmployeeDto schema details"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employeedto {
    private Long id;
    @Schema(
            description = "First Name"
    )
    private String firstName;
    @Schema(
            description = "Last Name"
    )
    private String lastName;
    @Schema(
            description = "email"
    )
    private String email;
    @Schema(
            description = "Department Code"
    )
    private String departmentCode;
    @Schema(
            description = "Organization Code"
    )
    private String organizationCode;
}
