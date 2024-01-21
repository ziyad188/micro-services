package ziyad.microservicerestart.com.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ziyad.microservicerestart.com.employeeservice.dto.APIResponseDto;
import ziyad.microservicerestart.com.employeeservice.dto.Employeedto;
import ziyad.microservicerestart.com.employeeservice.service.EmployeeService;

@Tag(
        name = "Employee Service - Employee Controller",
        description = "Employee Controller exposes REST APIs for Employee-Service"
)
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeService employeeService;
    @Operation(
            summary = "To create a Employee",
            description = "used to save employee details to the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )

    @PostMapping()
    private ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeedto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeedto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "To get  Employee",
            description = "used to get employee details from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 ok"
    )

    @GetMapping("{id}")
    private ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }
}
