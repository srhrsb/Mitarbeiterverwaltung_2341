package controller;
import dao.EmployeeDAO;
import dao.EmployeeListDAO;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {
    /**
     * Objekt mit dem die Mitarbeiterdaten zukünftig verwaltet werden
     */
    private EmployeeListDAO employeeDB;
    private MainView view;
    private final int EMPLOYEE_ID_LENGTH = 10;
    private final int MIN_INPUT_LENGTH = 2;

    public MainController( EmployeeListDAO employeeListDB, MainView view) {
        this.employeeDB = employeeListDB;
        this.view = view;

        view.addGetButtonHandler(this::getEmployeeAction);
        view.addSaveButtonHandler(this::saveEmployeeAction);
        view.addDeleteButtonHandler(this::deleteEmployeeAction);
        //Test();
    }

    public static void main(String[] args) {
        EmployeeListDAO employeeListDAO = new EmployeeListDAO();
        MainView view = new MainView( 500, 200);
        new MainController( employeeListDAO, view );
    }

    private void Test(){
        //ToDo: Mitarbeiter erzeugen via EmployeeDAO und Name, Vorname, Alter und Job
        //ToDo: ausgeben

        String id = createEmployeeID("Böttcher","Sebastian");
        employeeDB.addEmployee(id, "Böttcher", "Sebastian", "Dozent" );
        var employee = employeeDB.getEmployeeByID(id);
        System.out.println("Name: "+employee.getEmployeeID());
        System.out.println("Name: "+employee.getLastname());
        System.out.println("Vorname: "+employee.getFirstname());
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
    private void getEmployeeAction(ActionEvent event){
        System.out.println("Action Event: " + event.getActionCommand());

        var id = view.getEmployeeId();

        if(id.length() == EMPLOYEE_ID_LENGTH){
           var employee = employeeDB.getEmployeeByID( id );
           if(employee != null){
               view.setLastname( employee.getLastname() );
               view.setFirstname( employee.getFirstname() );
               view.setJob( employee.getJob() );
               view.showErrorWindow("Der Mitarbeiter wurde gefunden.");
           }
           else{
               System.err.println("employee not found");
               view.showErrorWindow("Der Mitarbeiter mit dieser ID wurde nicht gefunden.");
           }
        }
        else{
            System.err.println("wrong id length");
            view.showErrorWindow("Die Mitarbeiter ID enthält 10 Zeichen.");
        }
    }

    /**
     * Aktuell eingegebene Mitarbeiterdaten speichern
     * @param event
     */
    private void saveEmployeeAction(ActionEvent event){
        System.out.println("Action Event: " + event.getActionCommand());

        String firstname = view.getFirstname();
        String lastname = view.getLastname();
        String job = view.getJob();

        boolean inputEmpty = firstname.isEmpty() || lastname.isEmpty()
                             || job.isEmpty();

        if(!inputEmpty){

            boolean inputsValid = firstname.length() >= MIN_INPUT_LENGTH
                    && lastname.length() >= MIN_INPUT_LENGTH
                    && job.length() >= MIN_INPUT_LENGTH;

            if (inputsValid) {
                String employeeID = createEmployeeID(lastname, firstname);
                var success = employeeDB.addEmployee(employeeID, lastname, firstname, job);

                if(success) {
                    System.out.println("new employee saved");
                    String text = "Ein neuer Mitarbeiter wurde hinzugefügt:\n" +
                            "Name:    " + lastname + "\n" +
                            "Vorname: " + firstname + "\n" +
                            "ID:      " + employeeID + "\n" +
                            "Beruf:   " + job + "\n";

                    view.setEmployeeId(employeeID);
                    view.showInfoWindow(text);
                }
                else{
                    System.err.println("add list failed");
                    view.showErrorWindow("Der Mitarbeiter konnte nicht hinzugefügt werden.");
                }
            } else {
                System.err.println("inputs not valid");
                view.showErrorWindow("Die Eingaben sollen mindestens zwei Zeichen lang sein");
            }
        }
        else {
            System.err.println("inputs missing");
            view.showErrorWindow("Nicht alle Textfelder sind ausgefüllt");
        }
    }

    /**
     * Mitarbeiter mit entsprechender ID löschen
     * @param event
     */
    private void deleteEmployeeAction(ActionEvent event){
        System.out.println("Action Event: " + event.getActionCommand());

        //ToDO




    }

}
