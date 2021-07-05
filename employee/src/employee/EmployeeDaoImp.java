package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImp {

	int row;
	Connection con = DBUtility.getConnection();
	String update = "update employee set firstname=?,lastname=?,salary=? where employee_id=?;";
	String delete = "delete from employee where employee_id=?";
	String showAll = "select*from employee";

	public boolean addData(Employee employee) {

		try {
			PreparedStatement ps = con
					.prepareStatement("insert into Employee(employee_id,firstname,lastname,salary) values(?,?,?,?)");
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());
			ps.setDouble(4, employee.getSalary());

			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (row > 0)
			return true;
		else
			return false;
	}

	public boolean updateData(Employee employee) {

		try {
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setDouble(3, employee.getSalary());
			ps.setInt(4, employee.getEmpId());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (row > 0)
			return true;
		else
			return false;
	}

	public boolean deleteData(int employeeId) {

		try {
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, employeeId);
			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (row > 0)
			return true;
		else
			return false;
	}

	public boolean showAllData()

	{
		try {
			PreparedStatement ps = con.prepareStatement(showAll);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				double salary = rs.getDouble("salary");
				System.out.println("ID: " + employee_id + " " + "|" + "First name: " + firstname + " " + "|"
						+ "Lastname: " + lastname + " " + "|" + "Salary: " + salary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (row > 0)
			return true;
		else
			return false;

	}
}
