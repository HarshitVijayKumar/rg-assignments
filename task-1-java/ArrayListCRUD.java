import java.util.ArrayList;
import java.util.Iterator;
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


public class ArrayListCRUD{
    private ArrayList<Employee> employeeList = new ArrayList<>();

    //CREATE
    public void create(int id, String name, String dept){
        Employee newEmployee = new Employee(id, name, dept);
        employeeList.add(newEmployee);
    }

    //READ
    public void read(){
        if (employeeList.isEmpty()){
            System.out.println("No employees found.");
            return ;
        }
        for (Employee e : employeeList){
            System.out.println(e.toString());
        }
    }

    //UPDATE 
    public void update (int id, String newName, String newDept){
        for (Employee e : employeeList){
            if (e.getId() == id){
                e.setName(newName);
                e.setDept(newDept);
                System.out.println("Employee Updated");
                return ;
            }
        }
        System.out.println("Employee not found");
    }

    //DE;ETE
    public static void delete(ArrayListCRUD a,int id){
        Iterator<Employee> iterator = a.employeeList.iterator();
        while (iterator.hasNext()){
            Employee e = iterator.next();
            if (e.getId() == id){
                iterator.remove();
                System.out.println("Employee deleted");
                return ;
            }
        }
        System.out.println("Employee not found");
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