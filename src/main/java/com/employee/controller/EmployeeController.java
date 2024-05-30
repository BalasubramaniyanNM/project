package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.exception.IdNotFoundException;
import com.employee.exception.InvalidAgeException;
import com.employee.exception.InvalidNameException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empser;
	@PostMapping(value="/add")
	public String addEmployee(@RequestBody Employee e)
	{
		return empser.addEmployee(e);
	}
	
	@GetMapping(value="/gee/{id}")
	public Employee getEmployee(@PathVariable int id) throws IdNotFoundException
	{
		return empser.getEmployee(id);
	}
	@PostMapping("/saveAll")
	public String saveAllEmp(@RequestBody List<Employee> e) 
	{
		return empser.saveAllEmp(e);
	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmp()
	{
		return empser.findAllEmp();
	}
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id)
	{
		return empser.deleteById(id);
	}
	@GetMapping(value="/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) throws InvalidNameException
	{
		return empser.getByName(name);
	}
	@GetMapping(value="/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender)
	{
		return empser.getByGender(gender);
	}
	@GetMapping(value="/getBySalary/{salary1}/{salary2}")
	public List<Employee> getBySalary(@PathVariable int salary1,@PathVariable int salary2)
	{
		return empser.getBySalary(salary1,salary2);
	}
	@GetMapping(value="/getMax/{salary}")
	public List<String> getMaxSalary(@PathVariable int salary,Employee e)
	{
		return empser.getMaxSalary(salary,e);
	}
	@GetMapping(value="/getMin/{salary}")
	public List<Integer> getMin(@PathVariable int salary,Employee e)
	{
		return empser.getMin(salary,e);
	}
	@PostMapping(value="/addEmp/")
	public Employee addEmp(@RequestBody Employee e) throws InvalidAgeException
	{
		return empser.addEmp(e);
	}
	@PutMapping(value="/update/{id}")
	public String updateEmp(@PathVariable int id,@RequestBody Employee e)
	{
		return empser.updateEmp(id,e);
	}
	@PatchMapping(value="/upd/{id}")
	public String getEmp(@PathVariable int id,@RequestBody Employee age) 
	
	{
		return empser.getEmp(id,age.getAge());
	}
	@GetMapping(value="/getBySal/{s1}/{s2}")
	public List<Employee> getBySal(@PathVariable int s1,@PathVariable int s2)
	{
		return empser.getBySal(s1,s2);
	}
	@GetMapping(value="/getByNam/{n}")
	public List<Employee> getByVal(@PathVariable String n)
	{
		return empser.getByValue(n);
	}
	@GetMapping(value="/getR/{name}/{gender}")
	public List<Employee> getRes(@PathVariable String name,@PathVariable String gender)
	{
		return empser.getRes(name,gender);
	}
	@GetMapping(value="/v/{salary}")
	public List<Employee> getDetail(@PathVariable int salary)
	{
		return empser.getSalDetail(salary);
	}
	@GetMapping(value="/s/{salary}/{offset}")
	public List<Employee> getLimit(@PathVariable int salary,@PathVariable int offset)
	{
		return empser.getLimit(salary,offset);
	}
	@GetMapping(value="/get/{id}")
	public Employee getById(@PathVariable int id) throws IdNotFoundException
	{
		return empser.getById(id);
	}
	@PostMapping("/addage")
	public String addAge(@RequestBody Employee e) throws InvalidAgeException
	{
		return empser.addAge(e);
	}
	
	
	
	
	
	
	//@GetMapping(value="/a/{salary1}/{salary2}")
//	public List<Employee> getSalary(@PathVariable int salary1,@PathVariable int salary2)
//	{
//		return empser.getSalary(salary1,salary2);
//	}
	
/*	@PostMapping(value="/ageexception")
	public String addEmp1(@RequestBody Employee e) throws InvalidAgeException
	{
		return empser.addEmpp(e);
	}	
	}*/
	
	
}