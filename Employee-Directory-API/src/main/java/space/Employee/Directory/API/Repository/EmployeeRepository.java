
package space.Employee.Directory.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import space.Employee.Directory.API.Model.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String Name);

}
