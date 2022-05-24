package pl.altkom.springcloud.lab05.configserver.employeeservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.altkom.springcloud.lab05.configserver.employeeservice.controller.model.CreateEmployeeRequest;
import pl.altkom.springcloud.lab05.configserver.employeeservice.controller.model.Employee;
import pl.altkom.springcloud.lab05.configserver.employeeservice.controller.model.UpdateEmployeeRequest;
import pl.altkom.springcloud.lab05.configserver.employeeservice.service.EmployeeService;

@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/project/{projectId}")
    public List<Employee> getProjectEmployees(@PathVariable("projectId") final Long projectId) {
        return employeeService.getProjectEmployees(projectId);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody final CreateEmployeeRequest request) {
        return employeeService.addEmployee(request);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long employeeId, @Valid @RequestBody final UpdateEmployeeRequest request) {
        return employeeService.modifyEmployee(employeeId, request);
    }
}
