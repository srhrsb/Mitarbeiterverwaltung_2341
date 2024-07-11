package dao;

import model.Employee;

import java.util.ArrayList;

public class EmployeeListDAO {
    /**
     * erweiterbare Liste der Mitabeiter
     */
    private ArrayList<Employee> employees = new ArrayList<>();

    private final String CSV_SAVE_PATH ="data/employees.csv";
    private final String CSV_SEPARATOR = ",";


    public boolean addEmployee( String employeeID, String lastname,
                                String firstname, String job ){

       Employee employee = new Employee(employeeID, lastname, firstname, job);
       var success = employees.add(employee);
       return success;
    }

    private boolean saveCSV(){





        return false;
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
}
