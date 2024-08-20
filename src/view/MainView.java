package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private  JButton getEmployeeBtn, saveEmployeeBtn, deleteEmployeeBtn, showAllEmployeeBtn;
    private JTextField employeeIdTf, lastnameTf, firstnameTf, jobTf, roomTf, phoneTf;


    public MainView( int width, int height ){

        setSize( width, height );
        setFont( new Font("Arial", Font.PLAIN, 20));
        setTitle("Mitarbeiterverwatung");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        addUIComponents();
        setVisible(true);
        pack();
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
        showAllEmployeeBtn = new JButton("Alle Mitarbeiter anzeigen");

        employeeIdTf = new JTextField();
        lastnameTf = new JTextField();
        firstnameTf = new JTextField();
        jobTf = new JTextField();
        roomTf = new JTextField();
        phoneTf = new JTextField();

        JLabel employeeIdLabel = new JLabel("Mitarbeiter ID:");
        JLabel lastnameLabel = new JLabel("Nachname:");
        JLabel firstnameLabel = new JLabel("Vorname:");
        JLabel jobLabel = new JLabel("Tätigkeit:");
        JLabel phoneLabel = new JLabel("Telefon:");
        JLabel roomLabel = new JLabel("Raum:");

        JLabel topLabel = new JLabel("Mitarbeiterdaten hinzufügen, ändern oder löschen");

        //einfügen
        topPanel.add(topLabel);

        centerPanel.setLayout( new GridLayout( 6, 2));
        centerPanel.setBorder( new EmptyBorder(5,5,5,5));
        centerPanel.add(employeeIdLabel);
        centerPanel.add(employeeIdTf);
        centerPanel.add(firstnameLabel);
        centerPanel.add(firstnameTf);
        centerPanel.add(lastnameLabel);
        centerPanel.add(lastnameTf);
        centerPanel.add(jobLabel);
        centerPanel.add(jobTf);
        centerPanel.add(phoneLabel);
        centerPanel.add(phoneTf);
        centerPanel.add(roomLabel);
        centerPanel.add(roomTf);

        bottomPanel.add(getEmployeeBtn);
        bottomPanel.add(saveEmployeeBtn);
        bottomPanel.add(deleteEmployeeBtn);
        bottomPanel.add(showAllEmployeeBtn);

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
    public void addShowAllButtonHandler(ActionListener listener){
        showAllEmployeeBtn.addActionListener(listener);
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

    public String getEmployeeId(){
        return employeeIdTf.getText();
    }

    public void setEmployeeId( String id ){
       employeeIdTf.setText(id);
    }

    public String getPhone(){
        return phoneTf.getText();
    }

    public void setPhone( String id ){
        phoneTf.setText(id);
    }

    public int getRoom(){

        int nr = 0;

        try {
            //es wird versucht Operationen auszuführen
            nr = Integer.parseInt( roomTf.getText() );

        }
        catch ( NumberFormatException e ) {
            //das tritt ein, wenn in try ein Fehler aufgetreten ist
            showErrorWindow("Keine gültige Raum Nummer");
            throw new RuntimeException(e);
        }
        finally {
            //optional: wird immer ausgeführt


        }

        return nr;
    }

    public void setRoom( int number ){

        roomTf.setText( String.valueOf(number));
    }


    /**
     * Zeigt ein Information für den Nutzer in einem Infofenster
     * @param text - Text der angezeigt werden soll
     */
    public void showInfoWindow( String text){
        JOptionPane.showMessageDialog(this, text, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Zeigt eine Fehlermeldung für den Nutzer in einem fenster
     * @param text - Text der angezeigt werden soll
     */
    public void showErrorWindow( String text){
        JOptionPane.showMessageDialog(this, text, "Fehler", JOptionPane.ERROR_MESSAGE);
    }

}
