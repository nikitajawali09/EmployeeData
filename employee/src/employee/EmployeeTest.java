package employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EmployeeTest {
	public static void main(String[] args) throws IOException {
		int empId, choice;
		String firstName, lastName;
		double salary;
		boolean flag;

		EmployeeDaoImp edao = new EmployeeDaoImp();

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(
				"Enter \n1.Add Employee data \n2.Update Employee data \n3.Delete Employee data \n4.Show all Employee data");

		choice = sc.nextInt();
		Employee employee;
		switch (choice) {
		case 1:
			System.out.println("-----Add New Employee data----");
			System.out.println("Enter Employee Id:");
			empId = sc.nextInt();
			System.out.println("Enter Employee First name:");
			firstName = br.readLine();
			System.out.println("Enter Employee Last name:");
			lastName = br.readLine();
			System.out.println("Enter Employee Salary:");
			salary = sc.nextDouble();

			employee = new Employee(empId, firstName, lastName, salary);
			flag = edao.addData(employee);

			if (flag == true) {
				System.out.println("Employee data added Succesfully ");
			} else {
				System.out.println("Failed");
			}
			break;

		case 2:
			System.out.println("-----Update Employee data----");
			System.out.println("Enter Employee First name:");
			firstName = br.readLine();
			System.out.println("Enter Employee Last name:");
			lastName = br.readLine();
			System.out.println("Enter Employee Salary:");
			salary = sc.nextDouble();
			System.out.println("Enter existing Employee Id:");
			empId = sc.nextInt();

			employee = new Employee(empId, firstName, lastName, salary);
			flag = edao.updateData(employee);

			if (flag == true) {
				System.out.println("Succesfully Updated");
			} else {
				System.out.println("Failed");
			}

			break;

		case 3:
			System.out.println("-----Delete Employee data-----");
			System.out.println("Enter Exisiting Employee Id : ");
			empId = sc.nextInt();
			flag = edao.deleteData(empId);
			if (flag == true) {
				System.out.println("Successfully Deleted Employee details ");
			} else {
				System.out.println("Failed");
			}
			break;

		case 4:
			System.out.println("------------All Employee data records------");
			System.out.println();
			flag = edao.showAllData();
			if (flag == false) {
				System.out.println();
				System.out.println("End");
			} else {
				System.out.println("Failed");
			}
			break;

		default:
			System.out.println("No such options available here !!");
			System.out.println("Enter \n1.Add Employee data \n2.Update Employee data \n3.Delete Employee data");
			choice = sc.nextInt();
			sc.close();
			break;
		}

	}
}
