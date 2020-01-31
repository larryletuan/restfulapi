package vnptit.com.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vnptit.com.vn.dao.EmployeeDao;
import vnptit.com.vn.entity.Employee;

@Service
public class employeeService {
  
@Autowired
private EmployeeDao empDao;	
//get employee 
public Employee getEmployee(Long empId)
{
 return empDao.getEmpId(empId);	
}
//get all employee 
public List<Employee> getAllEmployee()
{
  return empDao.listAllEmployees();	
}
//add an employee 
public Employee addEmployee(Employee emp)
{
	 return empDao.addEmp(emp);
}
//update an employee
public Employee updateEmployee(Employee emp)
{
   return empDao.updateEmp(emp);	
}
//delete an employee 
public void deleteEmployee(Long empId)
{
    empDao.deleteEmployee(empId);
}
}
