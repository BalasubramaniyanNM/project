package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.exception.IdNotFoundException;
import com.employee.exception.InvalidAgeException;
import com.employee.exception.InvalidNameException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public Employee getEmployee(int id) throws IdNotFoundException {
		return empDao.getEmployee(id);
	}

	public String saveAllEmp(List<Employee> e) {
		return empDao.saveAllEmp(e);
	}

	public List<Employee> findAllEmp() {
		return empDao.findAllEmp();
	}

	public String deleteById(int id) {
		return empDao.deleteById(id);
	}

	public List<Employee> getByName(String name) throws InvalidNameException {
		List<Employee> x = empDao.findAllEmp();
		List<Employee> li = x.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
		if (li.isEmpty()) {
			throw new InvalidNameException("Invalid Name");
		} else {
			return li;
		}

	}

	public List<Employee> getByGender(String gender) {
		List<Employee> a = this.findAllEmp().stream().filter(e -> e.getGender().equals(gender))
				.collect(Collectors.toList());
		return a;
	}

	public List<Employee> getBySalary(int salary1, int salary2) {
		return this.findAllEmp().stream().filter(e -> e.getSalary() > salary1 && e.getSalary() < salary2)
				.collect(Collectors.toList());
	}

	public List<String> getMaxSalary(int salary, Employee e) {
		return empDao.getMaxSalary(salary, e);
	}

	public List<Integer> getMin(int salary, Employee e) {
		return empDao.getMin(salary, e);
	}

	public Employee addEmp(Employee e) {
		return empDao.addEmp(e);
	}

	public String updateEmp(int id, Employee e) {
		return empDao.updateEmp(id, e);

	}

	public String getEmp(int id, int age) {
		return empDao.getEmp(id, age);
	}

	public List<Employee> getBySal(int s1, int s2) {
		return empDao.getBySal(s1, s2);
	}

	public List<Employee> getByValue(String n) {
		return empDao.getByValue(n);
	}

	public List<Employee> getRes(String name, String gender) {
		return empDao.getByRes(name, gender);
	}

	public List<Employee> getSalDetail(int salary) {
		return empDao.getBySal(salary);
	}

	public List<Employee> getLimit(int salary, int offset) {
		return empDao.getByValue(salary, offset);
	}

//	public List<Employee> getSalary(int salary1,int salary2)
//	{
//		return empDao.getSalary(salary1,salary2);
//	}
	public String addAge(Employee e) throws InvalidAgeException {
		try {
			if (e.getAge() >= 18) {
				empDao.addAge(e);
				return "successfully saved";
			} 
				throw new InvalidAgeException("not eligible");
			
		} catch (Exception msg) {
			return msg.getMessage();
		}
	}

	public Employee getById(int id) throws IdNotFoundException {
			Employee a=empDao.getById(id);
			if(a.getId()!=id)
			{
			throw new IdNotFoundException("id not in data");
			}
		 return a;
		
		
		
	}
	

}
