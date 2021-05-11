package com.ckant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    private static Statement statement = null;
    private Connection conn;

    public EmployeeDaoImpl() throws SQLException {
        conn = ConnectionFactory.getConnection();
        statement = conn.createStatement();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException{
    	String sql ="insert into employee values(" + employee.getEmpId() + ",'" + employee.getName() +"','"+ employee.getEmail() +"')";
    	int count = 0;
    	count = statement.executeUpdate(sql);
    	if(count > 0) {
    		System.out.println("Employee saved");
    		
    	}
    	else
    		System.out.println("Employee  not saved");
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException{
    	 String sql = "update employee set name='"+employee.getName()+"', email='"+employee.getEmail()+"' where empId="+ employee.getEmpId();
         int count = 0;
         count = statement.executeUpdate(sql);

         if (count > 0) {
             System.out.println("Employee saved");
         } else {
             System.out.println("Not completed");
         }

    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        // write code for delete
        String sql = "delete from employee where empId= "+ id;
        int count = 0;
        count = statement.executeUpdate(sql);

        if (count > 0) {
            System.out.println("Employee saved");
        } else {
            System.out.println("Not completed");
        }
    }

    @Override
    public Employee getEmployeeById(int empId) throws SQLException {
        // write code for employee by id
        Employee employee = null;
        String sql = "select * from employee where empId = "+ empId;
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            int id = rs.getInt("empId");
            String name = rs.getString("name");
            String email = rs.getString("email");
            employee = new Employee(id, name, email);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
    	List<Employee>list = new ArrayList<>();
    	String sql="select * from employee";
    	ResultSet rs = statement.executeQuery(sql);
    	while(rs.next()) {
    		int id = rs.getInt("empId");
    		String name = rs.getString("name");
    		String email = rs.getString("email");
    		Employee employee = new Employee(id,name,email);
    		list.add(employee);
    	}
    	
    	
        return list;
    }

	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
