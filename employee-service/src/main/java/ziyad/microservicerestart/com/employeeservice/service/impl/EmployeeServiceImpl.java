package ziyad.microservicerestart.com.employeeservice.service.impl;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ziyad.microservicerestart.com.employeeservice.dto.APIResponseDto;
import ziyad.microservicerestart.com.employeeservice.dto.DepartmentDto;
import ziyad.microservicerestart.com.employeeservice.dto.Employeedto;
import ziyad.microservicerestart.com.employeeservice.dto.OrganizationDto;
import ziyad.microservicerestart.com.employeeservice.entity.Employee;
import ziyad.microservicerestart.com.employeeservice.repository.EmployeeRepository;
import ziyad.microservicerestart.com.employeeservice.service.APIDepartmentClient;
import ziyad.microservicerestart.com.employeeservice.service.APIOrganizationClient;
import ziyad.microservicerestart.com.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    //to check retry pattern working we using this log
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;
   // private WebClient webClient;

   private APIDepartmentClient apiDepartmentClient;
   private APIOrganizationClient apiOrganizationClient;
    @Override
    public Employeedto saveEmployee(Employeedto employeedto) {
        Employee employee = mapper.map(employeedto,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapper.map(savedEmployee,Employeedto.class);
    }

//    @Override
//    public APIResponseDto getEmployee(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).get();
//        //calling department from here using webclient
//        //here url then retrive then body to mono for specifying response typ and block to make synchronise call
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//        // here adding both to one response dto employee and department
//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setDepartmentDto(departmentDto);
//        apiResponseDto.setEmployeedto(mapper.map(employee,Employeedto.class));
//
//        return apiResponseDto;
//    }



    // implementation using open feign after done of interface do this first enable notaion in parent java class like @EnableFeignClients
    //then create a interface and then in service

    //here circuit breaker is used to avoid the issue of calling repeatdly and other promblems
    //here name is fetched from application.properties file and fallback method is where default message is added to get department service is down

    //@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefualtDepartment")

    //retry pattern same as circuit breaker
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefualtDepartment")
@Override
public APIResponseDto getEmployee(Long employeeId) {
    Employee employee = employeeRepository.findById(employeeId).get();
    //for making log to check retry pattern working
        LOGGER.info("inside getEmployee method");

    //to implement open feign contacting employye to department
   DepartmentDto departmentDto = apiDepartmentClient.getDepartment(employee.getDepartmentCode());
   //to contact employee to organization
        OrganizationDto organizationDto = apiOrganizationClient.getOrganization(employee.getOrganizationCode());
    // here adding both to one response dto employee and department
    APIResponseDto apiResponseDto = new APIResponseDto();
    apiResponseDto.setDepartmentDto(departmentDto);
    apiResponseDto.setOrganizationDto(organizationDto);
    apiResponseDto.setEmployeedto(mapper.map(employee,Employeedto.class));

    return apiResponseDto;
}

//fallback method implementation it should be same as the above method same parameter and return tyoe and along add exception too
    public APIResponseDto getDefualtDepartment(Long employeeId,Exception exception) {
        //for making log to check retry pattern working
        LOGGER.info("inside getDefualtDepartment method");
        Employee employee = employeeRepository.findById(employeeId).get();
        //creating default department in here
       DepartmentDto departmentDto = new DepartmentDto();
       departmentDto.setDepartmentCode("RD001");
       departmentDto.setDepartmentName("R&D Department");
       departmentDto.setDepartmentDescription("Reserch and Development Department");
       OrganizationDto organizationDto = new OrganizationDto();
       organizationDto.setOrganizationCode("XYZ_ORG");
       organizationDto.setOrganizationName("XYZ Organiztion");
       organizationDto.setOrganizationDescription("XYZ Organization Description");


        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        apiResponseDto.setEmployeedto(mapper.map(employee,Employeedto.class));

        return apiResponseDto;

    }
}
