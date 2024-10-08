package dao;

import model.Employee;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class EmployeeListDAO {
    /**
     * erweiterbare Liste der Mitabeiter
     */
    private ArrayList<Employee> employees = new ArrayList<>();

    private final String CSV_SAVE_PATH ="data/employees.csv";
    private final String CSV_SEPARATOR = ",";


    public EmployeeListDAO() {
      loadCSV();
    }

    public boolean addEmployee(String employeeID, String lastname,
                               String firstname, String job, String phone, int room ){

       Employee employee = new Employee(employeeID, lastname, firstname, job, phone, room);
       var success = employees.add(employee);

       if(success){
           return saveCSV();
       }

       return success;
    }

    public boolean saveCSV(){

        try{
            FileWriter csv = new FileWriter( CSV_SAVE_PATH );

            for( var employee : employees ){

                String line = employee.getEmployeeID() + CSV_SEPARATOR +
                              employee.getFirstname() + CSV_SEPARATOR +
                              employee.getLastname() + CSV_SEPARATOR +
                              employee.getJob() + CSV_SEPARATOR +
                              employee.getPhone() + CSV_SEPARATOR +
                              employee.getRoom() +
                              "\n";

                csv.write( line );
            }

            csv.close();
            return true;
        }
        catch( Exception e ){
            throw new RuntimeException(e);
        }
    }

    private void loadCSV(){

        try{
            var path = Path.of( CSV_SAVE_PATH);
            String csvText = Files.readString( path );

            if(csvText.isEmpty())
                return;

            String[] lines = csvText.split( "[[\\r\\n]+]");

            for(var line : lines){

                String[] values = line.split(CSV_SEPARATOR);

                Employee employee =  new Employee(
                       values[0], //id
                       values[2], //lastname
                       values[1], //firstname
                       values[3],  //job
                       values[4], //phone
                       Integer.parseInt(values[5])  //room
                );

                employees.add(employee);
            }
        }
        catch( Exception e ){
            throw new RuntimeException(e);
        }
    }

    /**
     * Gibt den Mitarbeiter mit der entsprechenden ID zurück, falls nicht gefunden null
     * @param employeeID
     * @return employee
     */
    public Employee getEmployeeByID( String employeeID ){
        for( var employee : employees){
            if(employee.getEmployeeID().equals(employeeID)){
               return employee;
            }
        }

        return null;
    }

    public boolean removeEmployeeByID( String employeeID ){
        for( var employee : employees){
            if(employee.getEmployeeID().equals(employeeID)){
               return employees.remove(employee);
            }
        }

        return false;
    }

    public String getAllEmployeesAsText(){
        String txt = "";

        for( var employee : employees){
            txt +="ID: "+employee.getEmployeeID() +"\n";
            txt +="Name: "+employee.getLastname() +"\n";
            txt +="Vorname: "+employee.getFirstname() +"\n";
            txt +="Job: "+employee.getJob()+"\n";
            txt +="Telefon: "+employee.getPhone()+"\n";
            txt +="Raum: "+employee.getRoom()+"\n";
            txt += "\n";
        }

        return txt;
    }





}
