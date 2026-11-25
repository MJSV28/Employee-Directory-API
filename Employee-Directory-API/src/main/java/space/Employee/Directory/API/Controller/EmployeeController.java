package space.Employee.Directory.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import space.Employee.Directory.API.Model.Employee;
import space.Employee.Directory.API.Service.EmployeeService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/spring/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeserv;

	@PostMapping("/add")
	public Employee addemployee(@RequestBody Employee employee) {
		return employeeserv.addemployee(employee);
	}

	@GetMapping("/get")
	public List<Employee> Getemployee() {
		return employeeserv.getemployee();
	}

	@GetMapping("/get/{id}")
	public Employee getemployeebyid(@PathVariable int id) {
		return employeeserv.getemployeebyid(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteemployeebyid(@PathVariable int id) {
		employeeserv.deleteemployeebyid(id);
		return "Employee Deleted Successfully ";
	}

	@PatchMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {

		return employeeserv.updateemployeebyid(id, employee.getName(), employee);
	}
	
	@GetMapping("/search")
	public List<Employee> findbyname(@RequestParam String Name) {
		return employeeserv.findbyname(Name);
	}
}
