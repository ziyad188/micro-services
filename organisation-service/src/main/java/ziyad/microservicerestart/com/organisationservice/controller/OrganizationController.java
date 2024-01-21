package ziyad.microservicerestart.com.organisationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ziyad.microservicerestart.com.organisationservice.dto.OrganizationDto;
import ziyad.microservicerestart.com.organisationservice.service.OrganizationService;

@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization Controller exposes REST APIs for Organization-Service"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private OrganizationService organizationService;

    @Operation(
            summary = "To create a Organization",
            description = "used to save organization to the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )

    //create organization
    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){
        return new ResponseEntity<>(organizationService.createOrganization(organizationDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "To get a Organization",
            description = "used to get organization from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 ok"
    )
    //get organization
    @GetMapping("{id}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("id") String organizationCode){
        return ResponseEntity.ok(organizationService.getOrganization(organizationCode));
    }
}
