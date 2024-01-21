package ziyad.microservicerestart.com.organisationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ziyad.microservicerestart.com.organisationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
