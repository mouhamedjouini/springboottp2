package impl;

import java.util.List;

import org.springframework.stereotype.Service;

import MODEL.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee", "Id", id));

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee existingEmployee =
				employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee",
				"Id", id));
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setEmail(employee.getEmail());
				// save existing employee to DB
				employeeRepository.save(existingEmployee);
				return existingEmployee;
				}

	
	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}

}
