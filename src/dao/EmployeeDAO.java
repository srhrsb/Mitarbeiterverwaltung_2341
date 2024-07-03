package dao;

import model.Employee;

public class EmployeeDAO {

    private Employee[] employees = new Employee[10];

    public EmployeeDAO() {


    }

    /**
     * Fügt einen Mitarbeiter zur Mitarbeiterliste hinzu
     * @param employeeID Mitarbeiter ID des Mitarbeiters
     * @param lastname
     * @param firstname
     * @param job
     */
    public boolean addEmployee( String employeeID, String lastname,
                             String firstname, String job ){

        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null){
                Employee employee = new Employee(employeeID, lastname, firstname,  job);
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt den Mitarbeiter mit der entsprechenden ID zurück, falls nicht gefunden null
     * @param employeeID
     * @return employee
     */
    public Employee getEmployeeByID( String employeeID ){

        for(var employee : employees){
            if(employee != null && employee.getEmployeeID() == employeeID)
                return employee;
        }

        return null;
    }


    public Employee[] getEmployeesByLastname( String name ){



        return null;
    }
}
