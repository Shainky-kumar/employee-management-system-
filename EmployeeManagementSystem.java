import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees   =  new ArrayList<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Employee Mnagement System");
            System.out.println("1. Create Employee");
            System.out.println("2.Update Employee");
            System.out.println("3.Delete Emplyee");
            System.out.println("4.Display All Employees");
            System.out.println("5.Search Employee by ID");
            System.out.println("6.Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CreateEmployee(scanner);
                    break;
                case 2:
                    UpdateEmployee(scanner);
                    break;
                case 3:
                    DeleteEmployee(scanner);
                    break;
                case 4:
                    DisplayAllEmployee();
                    break;
                 case 5:
                    SearchEmployeebyId(scanner);
                    break;
                case 6:
                   System.out.println("Exiting.....");
                   return;
                default:
                    System.out.println("Invalid choice please try again");
            }
        }
    }

    private void  CreateEmployee(Scanner scanner) {
        System.out.println("Enter emplyee Id:");
        int id = scanner.nextInt();
        System.out.println("Enter Emplyee Name :");
        String name = scanner.next();
        System.out.println(" Enter Employee department");
        String department = scanner.next();
        System.out.println("Enter Emplyee salary ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(id, name, salary, department);
      employees.add(employee);
      System.out.println("Employee Create Successfully !");
    }

    private void  UpdateEmployee(Scanner scanner) {
        System.out.println("Enter emplyee Id:");
        int id = scanner.nextInt();
        System.out.println("Enter Emplyee Name :");
        String name = scanner.next();
        System.out.println(" Enter Employee department");
        String department = scanner.next();
        System.out.println("Enter Emplyee salary ");
      double salary = scanner.nextDouble();
      Employee employee = getEmployeeById(id);
      if(employee != null) {
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        System.out.println("Employer updated successfully!");
      } else {
        System.out.println("Employee not found !");
      }
    }

    private void DeleteEmployee(Scanner scanner) {
   System.out.println("Enter Employee Id:");
   int id = scanner.nextInt();
   Employee employee = getEmployeeById(id);
   if(employee != null) {
    employees.remove(employee);
    System.out.println("Employee desuccessfullyleted ");
   } else {
    System.out.println("Employee not found ");
   }
    }

    private void DisplayAllEmployee() {
        for(Employee employee : employees) {
            System.out.println("ID:" + employee.getId() + ",name:" + employee.getName() + ",department: " + employee.getDepartment() + ",salary" + employee.getSalary());
        }
    }
    
    private void SearchEmployeebyId(Scanner scanner) {
        System.out.println("Enter employee ID:");
        int id = scanner.nextInt();
        Employee employee = getEmployeeById(id);
        if(employee != null) {
            System.out.println("ID: " + employee.getId() + ", Name:" + employee.getName() + ",department: " + employee.getDepartment()+ ",salary: "+ employee.getSalary());
} else {
    System.out.println("Employee not found:");
}
   } 

   private Employee getEmployeeById( int id) {
    for(Employee employee : employees) {
        if(employee.getId() != id ) {
            return employee;
        }
    }
    return null;
   }

   private class Employee {
    private int id;
    private String name ;
    private String department;
   private double salary;

   public Employee(int id, String name, double salary, String department) {
    this.id = id;
    this.name = name ;
    this.salary = salary;
    this.department = department;
   }

   public int getId() {
    return id;
   }
   public void setId(int id) {
    this.id = id;
   }
   public String getName() {
    return name;
   }
   public void setName(String name ) {
    this.name = name ;
   }
    public String getDepartment() {
return department;
   }
   public void setDepartment(String department) {
this.department = department;
   }
   public double getSalary() {
    return salary;
   }
   public void setSalary(double salary) {
    this.salary = salary;
   }
   }
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.run();
    }
}
