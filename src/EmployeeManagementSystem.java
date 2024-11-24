import java.util.*;

public class EmployeeManagementSystem {
    private Map<String, Employee> employees;
    private Map<String, Project> projects;
    private final String adminUsername = "Ankur";
    private final String adminPassword = "1234";

    public EmployeeManagementSystem() {
        this.employees = new HashMap<>();
        this.projects = new HashMap<>();
    }

    public boolean login(String username, String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    public void addEmployee(String empId, String name, String department) {
        employees.put(empId, new Employee(empId, name, department));
    }

    public void updateEmployee(String empId, String name, String department, String projectId) {
        Employee emp = employees.get(empId);
        if (emp != null) {
            emp.setName(name);
            emp.setDepartment(department);
            emp.setProjectId(projectId);
        }
    }

    public void addProject(String projectId, String name) {
        projects.put(projectId, new Project(projectId, name));
    }

    public void mapEmployeeToProject(String empId, String projectId) {
        Employee emp = employees.get(empId);
        Project proj = projects.get(projectId);
        if (emp != null && proj != null) {
            emp.setProjectId(projectId);
            proj.addEmployee(empId);
        }
    }

    public void viewAllEmployees() {
        for (Employee emp : employees.values()) {
            System.out.println("ID: " + emp.getEmpId() + ", Name: " + emp.getName() +
                    ", Department: " + emp.getDepartment() + ", Project: " + emp.getProjectId());
        }
    }

    public void viewAllProjects() {
        for (Project proj : projects.values()) {
            System.out.println("Project ID: " + proj.getProjectId() + ", Name: " + proj.getName() +
                    ", Employees: " + String.join(", ", proj.getEmployeeIds()));
        }
    }

    public void viewProjectsForEmployee(String empId) {
        Employee emp = employees.get(empId);
        if (emp != null) {
            System.out.println("Employee ID: " + emp.getEmpId() + ", Name: " + emp.getName() + ", Project: " + emp.getProjectId());
        }
    }

    public void viewEmployeesForProject(String projectId) {
        Project proj = projects.get(projectId);
        if (proj != null) {
            System.out.println("Project ID: " + proj.getProjectId() + ", Name: " + proj.getName() +
                    ", Employees: " + String.join(", ", proj.getEmployeeIds()));
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Admin Login");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (!ems.login(username, password)) {
            System.out.println("Invalid login credentials.");
            return  ;
        }

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Add Project");
            System.out.println("4. Assign Employee to Project");
            System.out.println("5. View All Employees");
            System.out.println("6. View All Projects");
            System.out.println("7. View Projects for Employee");
            System.out.println("8. View Employees for Project");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String empId = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Department: ");
                    String department = scanner.nextLine();
                    ems.addEmployee(empId, name, department);
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    empId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Department: ");
                    department = scanner.nextLine();
                    System.out.print("Enter New Project ID: ");
                    String projectId = scanner.nextLine();
                    ems.updateEmployee(empId, name, department, projectId);
                    break;
                case 3:
                    System.out.print("Enter Project ID: ");
                    projectId = scanner.nextLine();
                    System.out.print("Enter Project Name: ");
                    name = scanner.nextLine();
                    ems.addProject(projectId, name);
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    empId = scanner.nextLine();
                    System.out.print("Enter Project ID: ");
                    projectId = scanner.nextLine();
                    ems.mapEmployeeToProject(empId, projectId);
                    break;
                case 5:
                    ems.viewAllEmployees();
                    break;
                case 6:
                    ems.viewAllProjects();
                    break;
                case 7:
                    System.out.print("Enter Employee ID: ");
                    empId = scanner.nextLine();
                    ems.viewProjectsForEmployee(empId);
                    break;
                case 8:
                    System.out.print("Enter Project ID: ");
                    projectId = scanner.nextLine();
                    ems.viewEmployeesForProject(projectId);
                    break;
                case 9:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}


