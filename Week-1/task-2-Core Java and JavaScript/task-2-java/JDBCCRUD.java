import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
	private int id;
	private String name;
	private String department;

	public Employee(int id, String name, String department){
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}

	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}

	public String getDept() {return this.department;}
	public void setDept(String dept) {this.department = dept;}

	@Override
	public String toString(){
		return "Employee [ID= "+this.id+", Name = "+this.name+" , Department = "+this.department +"]";
	}
}


public class JDBCCRUD{
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "AdventureTime11!";

    //CREATE
    public void create(int id, String name, String dept){
        String query = "INSERT INTO employee (id, name, department) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setInt(1,id);
                stmt.setString(2,name);
                stmt.setString(3,dept);
                stmt.executeUpdate();

                System.out.println("Employee Added");
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        
    }

    //READ
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employee";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")
                );
                list.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    //UPDATE 
    public void updateEmployee(int id, String name, String dept) {
        String query = "UPDATE employee SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, dept);

            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Employee updated.");
            else
                System.out.println("Employee not found.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //DELETE
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted.");
            else
                System.out.println("Employee not found.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        ArrayListCRUD employees = new ArrayListCRUD();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\n1. Create \n2. Read \n3. Update \n4. Delete \n5. Exit");

        do {
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            int new_id;
            String new_name, new_dept;

            switch(choice){
                case 1:
                    System.out.println("Enter your ID : ");
                    new_id = sc.nextInt();
                    System.out.println("Enter your name : ");
                    new_name = sc.next();
                    System.out.println("Enter your depatment : ");
                    new_dept = sc.next();
                    employees.create(new_id,new_name,new_dept);
                    break;
                case 2: 
                    employees.read();
                    break;
                case 3: 
                    System.out.println("Enter the ID : ");
                    new_id = sc.nextInt();
                    System.out.println("Enter new name : ");
                    new_name = sc.next();
                    System.out.println("Enter the department : ");
                    new_dept = sc.next();
                    employees.update(new_id,new_name,new_dept);
                    break;
                case 4:
                    System.out.println("Enter the ID : ");
                    new_id = sc.nextInt();
                    employees.delete(employees, new_id);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
        } 
        while (choice != 5);
        sc.close();
    }
}