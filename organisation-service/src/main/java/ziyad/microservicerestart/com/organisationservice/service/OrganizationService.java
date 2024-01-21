package ziyad.microservicerestart.com.organisationservice.service;

import org.springframework.stereotype.Service;
import ziyad.microservicerestart.com.organisationservice.dto.OrganizationDto;


public interface OrganizationService {
    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganization(String organizationCode);

}
