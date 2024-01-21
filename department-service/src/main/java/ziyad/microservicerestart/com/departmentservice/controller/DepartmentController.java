package ziyad.microservicerestart.com.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ziyad.microservicerestart.com.departmentservice.dto.DepartmentDto;
import ziyad.microservicerestart.com.departmentservice.service.DepartmentService;

@Tag(
        name = "Department Service - Department Controller",
        description = "Department Controller exposes REST APIs for Departmnet-Service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    //api to save department;
    @Operation(
            summary = "To create a Department",
            description = "used to save department to the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "To get a Department",
            description = "used to get department from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 ok"
    )
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") String code){
        return ResponseEntity.ok(departmentService.getDepartment(code));
    }



}
