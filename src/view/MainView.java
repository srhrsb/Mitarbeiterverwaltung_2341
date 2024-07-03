package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private  JButton getEmployeeBtn, saveEmployeeBtn, deleteEmployeeBtn;
    private JTextField employeeIdTf, lastnameTf, firstnameTf, jobTf;


    public MainView( int width, int height ){

        setSize( width, height );
        setFont( new Font("Arial", Font.PLAIN, 20));
        setTitle("Mitarbeiterverwatung");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        addUIComponents();
        setVisible(true);
    }


    /**
     * Hinzufuegen von UI-Elementen
     */
    private void addUIComponents( ){

        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        getEmployeeBtn = new JButton("Mitarbeiter anzeigen");
        saveEmployeeBtn = new JButton("Mitarbeiter speichern");
        deleteEmployeeBtn = new JButton("Mitarbeiter löschen");

        employeeIdTf = new JTextField();
        lastnameTf = new JTextField();
        firstnameTf = new JTextField();
        jobTf = new JTextField();

        JLabel employeeIdLabel = new JLabel("Mitarbeiter ID:");
        JLabel lastnameLabel = new JLabel("Nachname:");
        JLabel firstnameLabel = new JLabel("Vorname:");
        JLabel jobLabel = new JLabel("Tätigkeit:");

        JLabel topLabel = new JLabel("Mitarbeiterdaten hinzufügen, ändern oder löschen");

        //einfügen
        topPanel.add(topLabel);

        centerPanel.setLayout( new GridLayout( 4, 2));
        centerPanel.setBorder( new EmptyBorder(5,5,5,5));
        centerPanel.add(employeeIdLabel);
        centerPanel.add(employeeIdTf);
        centerPanel.add(firstnameLabel);
        centerPanel.add(firstnameTf);
        centerPanel.add(lastnameLabel);
        centerPanel.add(lastnameTf);
        centerPanel.add(jobLabel);
        centerPanel.add(jobTf);

        bottomPanel.add(getEmployeeBtn);
        bottomPanel.add(saveEmployeeBtn);
        bottomPanel.add(deleteEmployeeBtn);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Eventlistener für GetEmpolyee Button hinzufügen
     * @param listener
     */
    public void addGetButtonHandler(ActionListener listener){
        getEmployeeBtn.addActionListener(listener);
    }

    /**
     * Eventlistener für SaveEmpolyee Button hinzufügen
     * @param listener
     */
    public void addSaveButtonHandler(ActionListener listener){
        saveEmployeeBtn.addActionListener(listener);
    }

    /**
     * Eventlistener für Delete Empolyee Button hinzufügen
     * @param listener
     */
    public void addDeleteButtonHandler(ActionListener listener){
        deleteEmployeeBtn.addActionListener(listener);
    }

    public String getFirstname(){
        return firstnameTf.getText();
    }

    public void setFirstname( String firstname ){
       firstnameTf.setText(firstname);
    }

    public String getLastname(){
        return lastnameTf.getText();
    }

    public void setLastname( String lastname ){
        lastnameTf.setText(lastname);
    }

    public String getJob(){
        return jobTf.getText();
    }

    public void setJob( String job ){
        jobTf.setText(job);
    }

    public void setEmployeeId( String id ){
       employeeIdTf.setText(id);
    }

}
