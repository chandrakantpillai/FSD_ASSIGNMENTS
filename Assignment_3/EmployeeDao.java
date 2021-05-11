package com.ckant;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int empId);
    List<Employee> getEmployees() throws SQLException;
	void deleteEmployee(int id) throws SQLException;
}
