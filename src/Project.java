import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectId;
    private String name;
    private List<String> employeeIds;

    public Project(String projectId, String name) {
        this.projectId = projectId;
        this.name = name;
        this.employeeIds = new ArrayList<>();
    }

    // Getters and Setters
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getEmployeeIds() { return employeeIds; }
    public void addEmployee(String empId) { this.employeeIds.add(empId); }
}
