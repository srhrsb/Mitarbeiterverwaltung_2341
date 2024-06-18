package model;

public class Employee {

    private String employeeID;
    private String lastname;
    private String firstname;
    private byte age;
    private String job;

    public Employee(String employeeID, String lastname, String firstname, byte age, String job) {
        this.employeeID = employeeID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    //endregion

}
