package repository;
import org.springframework.data.jpa.repository.JpaRepository;

import MODEL.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
