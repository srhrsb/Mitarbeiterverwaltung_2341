package controller;
import dao.EmployeeDAO;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {
    /**
     * Objekt mit dem die Mitarbeiterdaten zukünftig verwaltet werden
     */
    private EmployeeDAO employeeDB;
    private MainView view;

    public MainController( EmployeeDAO employeeDB, MainView view) {
        this.employeeDB = employeeDB;
        this.view = view;

        view.addGetButtonHandler(this::getEmployee);
        view.addSaveButtonHandler(this::saveEmployee);
        view.addDeleteButtonHandler(this::deleteEmployee);
        //Test();
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        MainView view = new MainView( 500, 200);
        new MainController( employeeDAO, view );
    }

    private void Test(){
        //ToDo: Mitarbeiter erzeugen via EmployeeDAO und Name, Vorname, Alter und Job
        //ToDo: ausgeben

        String id = createEmployeeID("Böttcher","Sebastian");
        employeeDB.addEmployee(id, "Böttcher", "Sebastian", (byte)47, "Dozent" );
        var employee = employeeDB.getEmployeeByID(id);
        System.out.println("Name: "+employee.getEmployeeID());
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

    /**
     * Mitarbeiter mit Hilfe der ID anfordern und anzeigen
     * @param event
     */
    private void getEmployee(ActionEvent event){
        System.out.println("Action Event: " + event.getActionCommand());
    }

    /**
     * Aktuell eingegebene Mitarbeiterdaten speichern
     * @param event
     */
    private void saveEmployee(ActionEvent event){
        System.out.println("Action Event: " + event.getActionCommand());
    }

    /**
     * Mitarbeiter mit entsprechender ID löschen
     * @param event
     */
    private void deleteEmployee(ActionEvent event){
        System.out.println("Action Event: " + event.getActionCommand());
    }

}
