package space.Employee.Directory.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import space.Employee.Directory.API.Model.Employee;
import space.Employee.Directory.API.Repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeerepo;

	public Employee addemployee(Employee employee) {
		return employeerepo.save(employee);
	}

	public List<Employee> getemployee() {
		return employeerepo.findAll();
	}

	public Employee getemployeebyid(int id) {
		return employeerepo.findById(id).orElse(null);
	}

	public void deleteemployeebyid(int id) {
		employeerepo.deleteById(id);
	}

	public String updateemployeebyid(int id, String name ,Employee employee) {

		if (employeerepo.existsById(id)) {
		//	employee.setId(id);
			employee.setName(name);
			employeerepo.save(employee);
			return "Employee updated successfully";
		}

		return "Employee id not found";
	}

	public List<Employee>findbyname(String Name) {
		return employeerepo.findByName(Name);
	}

}
