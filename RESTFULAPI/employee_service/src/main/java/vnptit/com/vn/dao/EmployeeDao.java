package vnptit.com.vn.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import vnptit.com.vn.entity.*;

@Repository
public class EmployeeDao {
   public static Map<Long,Employee> empMap = new HashMap<Long,Employee>();
  
   public EmployeeDao()
   {
	    Employee emp1 = new Employee(1L,"E01","larry");
		Employee emp2 = new Employee(2L,"E02","lucky");
		Employee emp3 = new Employee(3L,"E03","pa");
	    empMap.put(emp1.getEmpId(),emp1);
	    empMap.put(emp2.getEmpId(),emp2);
	    empMap.put(emp3.getEmpId(),emp3);   
   }
	//getMaxEmpId
	public Long getMaxEmpId()
	{
		Set<Long> keys = empMap.keySet(); 
		Long max = 0L;
		for(Long key:keys)
		{
			if(key>max)
			{
				max=key;
			}
		}
		return max;
	}
	//get Employee
	public Employee getEmpId(Long empId)
	{
		return empMap.get(empId);
	}
	//add Employee 
	public Employee addEmp(Employee emp)
	{
		Long empId = getMaxEmpId()+1;
		emp.setEmpId(empId);
		empMap.put(emp.getEmpId(),emp);
		return emp;
	}
	//update Employee
	public Employee updateEmp(Employee emp)
	{
		Employee updateEmp = this.getEmpId(emp.getEmpId());
		if(updateEmp!=null)
		{
		  updateEmp.setEmpName(emp.getEmpName());
		  updateEmp.setEmpNo(emp.getEmpNo());
		//  empMap.put(updateEmp.getEmpId(),updateEmp);	
		}
		return updateEmp;	
	}
	//delete employee
	public void deleteEmployee(Long id)
	{
	   empMap.remove(id);
	}
	//list all employee
	public List<Employee> listAllEmployees()
	{
		//chuyen tu map sang list su dung collection 
		Collection<Employee> c = empMap.values();
		List<Employee> list = new ArrayList<Employee>();
		list.addAll(c);
		return list;
		
	}

}
