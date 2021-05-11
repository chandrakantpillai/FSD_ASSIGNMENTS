package com.ckant;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        System.out.println("Please select any one options");
        System.out.println("**************");
        System.out.println("Press 1: Insert");
        System.out.println("Press 2: Update");
        System.out.println("Press 3: Delete");
        System.out.println("Press 4: Get");
        System.out.println("**************");

        int option = scanner.nextInt();
        switch (option){
            case 1: {
                insert();
                break;
            }
            case 2: {
                update();
                break;
            }
            case 3: {
                delete();
                break;
            }
            case 4: {
                get();
                break;
            }
            default: {
                System.out.println("Incorrect options");
            }
        }
		

        List<Employee> list =  dao.getEmployees();
        for (Employee emp:list) {
            System.out.println(emp.toString());
        }
    }
    private static void insert() throws SQLException{
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter EmpId: ");
    	int id= scanner.nextInt();
    	System.out.print("Enter Emp name: ");
		String name= scanner.next();
		System.out.print("Enter Emp email: ");
     	String email= scanner.next();
		Employee employee=new Employee(id,name,email);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
          dao.addEmployee(employee);
    }

    private static void update() throws SQLException{
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter EmpId where needs changes: ");
    	int id= scanner.nextInt();
    	System.out.print("Enter Emp name: ");
		String name= scanner.next();
		System.out.print("Enter Emp email: ");
     	String email= scanner.next();
		Employee employee=new Employee(id,name,email);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
          dao.updateEmployee(employee);

    }

    private static void delete() throws SQLException{
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter EmpId to delete: ");
    	int id= scanner.nextInt();
    	EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

    	dao.deleteEmployee(id);
    	
    	

    }

    private static void get() throws SQLException {

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        List<Employee> list =  dao.getEmployees();
        for (Employee emp:list) {
            System.out.println(emp.toString());
        }
//			
		}
	}


