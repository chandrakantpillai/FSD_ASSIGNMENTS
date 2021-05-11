package com.test.spring_orm_hibernate;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring_orm_hibernate.dao.EmployeeDao;
import com.test.spring_orm_hibernate.entities.Employee;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        		while (true) {
        			System.out.println("****************************************");
        			System.out.println("Press 1:Add employee");
        			System.out.println("Press 2:get all employee");
        			System.out.println("Press 3:get employee by id");
        			System.out.println("press 4: delete employee");
        			System.out.println("press 5: update employee");
        			System.out.println("press 6: exit");
        			System.out.println("****************************************");
        			
        			
        			try {
        				int input = Integer.parseInt(br.readLine());
        				switch(input) {
        				case 1 :
        					System.out.println("Enter employee by id");
        					int id = Integer.parseInt(br.readLine());
        					System.out.println("Enter employee name");
        					String name = br.readLine();
        					System.out.println("Enter employee email");
        					String email = br.readLine();
        					 Employee newEmployee = new Employee();
        					 newEmployee.setId(id);
        					 newEmployee.setName(name);
        					 newEmployee.setEmail(email);
        					 dao.addEmployee(newEmployee);
        					 System.out.println("Employee inserted successfully");
        					 
        					 break;
        					 
        					 
        					 
        				case 2:
        					List<Employee> employees = dao.getAllEmployee();
        					for(Employee employee: employees) {
        						System.out.println(employee);
        					}
        					break;
        					
        				case 3:
        					System.out.println("Enter employee by id");
        					int id3 = Integer.parseInt(br.readLine());
        					 Employee newEmployees =dao.getEmployeeById(id3);
        					 System.out.println(newEmployees);
        					
        					break;
        				case 4: 
        					System.out.println("Enter employee by id");
        					int id4 = Integer.parseInt(br.readLine());
        					 Employee newEmployees4 =dao.deleteEmployee(id4);
        					 System.out.println("deleted succesffuly");
        					break;
        					
        				case 5:
        				System.out.println("Enter employee by id");
    					int EmpId = Integer.parseInt(br.readLine());
    					System.out.println("Enter employee name");
    					String EmpName = br.readLine();
    					System.out.println("Enter employee email");
    					String Email = br.readLine();
    					
    					break;
    					
        				case 6 :
        					break;
        					default:
        						break;
        						
        				}
        				
        			} catch (Exception e) {
        				System.out.println("Invalid Selection");
        			}
        		}
        
        
    }
}

