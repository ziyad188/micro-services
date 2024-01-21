package ziyad.microservicerestart.com.organisationservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ziyad.microservicerestart.com.organisationservice.dto.OrganizationDto;
import ziyad.microservicerestart.com.organisationservice.entity.Organization;
import ziyad.microservicerestart.com.organisationservice.repository.OrganizationRepository;
import ziyad.microservicerestart.com.organisationservice.service.OrganizationService;


@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    private ModelMapper mapper;
    //save organization
    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = mapper.map(organizationDto,Organization.class);
        Organization savedOrganization = organizationRepository.save(organization);
        return mapper.map(savedOrganization,OrganizationDto.class);
    }
    //get code of organization
    @Override
    public OrganizationDto getOrganization(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return mapper.map(organization,OrganizationDto.class);
    }
}
