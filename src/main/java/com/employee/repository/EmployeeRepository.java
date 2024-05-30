package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	@Query(value="select * from employees where salary>=? and salary<=?",nativeQuery=true)
	public List<Employee> getBySal(int salary1,int salary2);
	
	@Query(value="select * from employees where name =?",nativeQuery=true)
	public List<Employee> getByNam(String n);
	
	@Query(value="select *from employees where name=? and gender=?",nativeQuery=true)
	public List<Employee> getRes(String name,String gender);
	
	@Query(value="select *from employees order by salary Desc limit ?",nativeQuery=true)
	public List<Employee> getData(int salary);

	@Query(value="select *from employees order by salary offset=? and Asc limit=?",nativeQuery=true)
	public List<Employee> getLimit(int limit,int offset);
	
//	@Query(value="select e from employees e where e.salary>=:sal1 and e.salary<=:sal2")
//	public List<Employee> getSalary(@Param("sal1") int sal1,@Param("sal2") int sal2);
	
}
