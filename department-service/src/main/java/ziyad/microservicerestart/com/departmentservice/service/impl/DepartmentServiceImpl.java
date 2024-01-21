package ziyad.microservicerestart.com.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ziyad.microservicerestart.com.departmentservice.dto.DepartmentDto;
import ziyad.microservicerestart.com.departmentservice.entity.Department;
import ziyad.microservicerestart.com.departmentservice.repository.DepartmentRepository;
import ziyad.microservicerestart.com.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper mapper;



    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapper.map(departmentDto,Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return mapper.map(savedDepartment,DepartmentDto.class);

    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return mapper.map(department,DepartmentDto.class);
    }
}
