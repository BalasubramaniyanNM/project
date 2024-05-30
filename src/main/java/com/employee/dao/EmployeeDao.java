package com.employee.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.exception.IdNotFoundException;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "successfully saved";
	}

	public Employee getEmployee(int id) throws IdNotFoundException {
		return empRepo.findById(id).orElseThrow(()->new IdNotFoundException("invalid id"));
	}

	public String saveAllEmp(List<Employee> e) {
		empRepo.saveAll(e);
		return "successfully saved all";

	}

	
	public List<Employee> findAllEmp() {
		return empRepo.findAll();
	}

	public String deleteById(int id) {
		empRepo.deleteById(id);
		return id + ": is deleted successfully";
	}

	public List<String> getMaxSalary(int salary, Employee e) {
		List<String> name = new ArrayList<>();
		return empRepo.findAll().stream().filter(x -> x.getSalary() > salary).map(x -> x.getName()).toList();
	}

	public List<Integer> getMin(int salary, Employee e) {
		List<Integer> id = new ArrayList<>();
		return empRepo.findAll().stream().filter(x -> x.getSalary() > salary).map(x -> x.getId()).toList();
	}

	public Employee addEmp(Employee e) {
		
			return empRepo.save(e);
		
	}
	public String updateEmp(int id,Employee e)
	{
		Employee em=empRepo.findById(id).get();
		em.setName(e.getName());
		empRepo.save(em);
		return "updated successfully";
	}
	public String getEmp(int id,int age)
	{
		Employee ec=empRepo.findById(id).get();
		ec.setAge(age);
		empRepo.save(ec);
		return "patch updated successfully";
	}
	public List<Employee> getBySal(int s1,int s2)
	{
		return empRepo.getBySal(s1, s2);
	}
	
	
	public List<Employee> getByRes(String name,String gender)
	{
		return empRepo.getRes(name, gender);
	}
	public List<Employee> getBySal(int salary)
	{
		return empRepo.getData(salary);
	}
	public List<Employee> getByValue(int salary,int limit)
	{
		return empRepo.getLimit(salary,limit);
	}
	

	public List<Employee> getByValue(String n) {
		// TODO Auto-generated method stub
		return null;
	}
	public Employee addAge(Employee e)
	{
		return empRepo.save(e);
	}
	

	public Employee getById(int id) throws IdNotFoundException {
		Optional<Employee> d=empRepo.findById(id);
		return d.orElseThrow(()->new IdNotFoundException("id not found"));
	}
	
	
//	public List<Employee> getSalary(int salary1,int salary2)
//	{
//		return empRepo.getSalary(salary1, salary2);
//	}

	}
