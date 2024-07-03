package model;

public class Employee {

    private String employeeID;
    private String lastname;
    private String firstname;
    private String job;

    public Employee(String employeeID, String lastname, String firstname, String job) {
        this.employeeID = employeeID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.job = job;
    }

    //region Getter and Setter
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    //endregion

}
