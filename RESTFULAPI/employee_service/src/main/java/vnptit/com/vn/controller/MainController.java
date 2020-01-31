package vnptit.com.vn.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vnptit.com.vn.entity.Employee;
import vnptit.com.vn.service.employeeService;

@RestController
public class MainController {
@Autowired
public employeeService empService;
@ResponseBody
@RequestMapping(value="/hello")
public String sayHello()
{
  return "hello";
}
@ResponseBody
@RequestMapping(value="/employees",method= RequestMethod.GET,
produces={MediaType.APPLICATION_JSON_VALUE})
public List<Employee> getAllEmployee()
{
	List<Employee> list = empService.getAllEmployee();
	return list;
}
//use POST to add an Employee 
@RequestMapping(value="/employees",method=RequestMethod.POST,
produces={MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
public Employee addEmployee(@RequestBody Employee emp)
{
   return empService.addEmployee(emp);
}
//use PUT to update an Employee
@RequestMapping(value="/employees",method=RequestMethod.PUT,
produces={MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
public Employee updateEmployee(@RequestBody Employee emp)
{
   return empService.updateEmployee(emp);
}
//use Delete to delete an Employee 
@RequestMapping(value="/employees/{empId}",method=RequestMethod.DELETE,
produces={MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
public String  deleteEmployee(@PathVariable("empId") Long empId)
{
	  empService.deleteEmployee(empId);
	  return "delete successfully";
}
}