package controller;
import dao.EmployeeDAO;

public class MainController {
    private EmployeeDAO employeeDB;

    public MainController(EmployeeDAO employeeDB) {
        this.employeeDB = employeeDB;
        Test();
    }

    public static void main(String[] args) {
        new MainController( new EmployeeDAO() );
    }

    private void Test(){
        //ToDo: Mitarbeiter erzeugen via EmployeeDAO und Name, Vorname, Alter und Job
        //ToDo: ausgeben
        employeeDB.addEmployee("TestID", "Böttcher", "Sebastian", (byte)47, "Dozent" );
        var employee = employeeDB.getEmployeeByID("TestID");
        System.out.println("Name: "+employee.getLastname());
        System.out.println("Vorname: "+employee.getFirstname());
        System.out.println("Alter: "+employee.getAge());
        System.out.println("Job: "+employee.getJob());
    }

    // Aufgabe: Erstellen Sie eine Methode die Namen, Vorname annimmt und daraus eine ID erzeugt
    // aus den ersten 2 Buchstaben vom Nachnamen und den ersten 2 vom Vorname
    // und einer 6-stelligen Zufallszahl
    private String createEmployeeID(String lastname, String firstname){
        return    lastname.substring(0,2)
                + firstname.substring(0,2)
                + (int)(Math.random() * 999999 );
    }

}
