public class Employee {
    private String empId;
    private String name;
    private String department;
    private String projectId;

    public Employee(String empId, String name, String department) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.projectId = "";
    }

    // Getters and Setters
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }
}
