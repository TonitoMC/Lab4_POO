import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class selectionPanel extends JPanel implements ActionListener{
    private JComboBox availableMagazineBox;
    private JComboBox availableBookBox;
    private JButton addBookButton;
    private JButton addMagazineButton;
    private JLabel bookListLabel;
    private JLabel magazineListLabel;
    private JLabel selectionPanelLabel;
    private JButton emptyListButton;
    private JButton showListButton;
    private JButton lendButton;
    private JButton profileButton;
    private ArrayList<String> bookList;
    private ArrayList<String> magazineList;
    public selectionPanel() {
        //construct preComponents
        bookList = new ArrayList<String>();
        magazineList = new ArrayList<String>();
        String[] availableMagazineBoxItems = {"Rev1", "Rev2", "Rev3"};
        String[] availableBookBoxItems = {"Libro1", "Libro2", "Libro3"};

        //construct components
        availableMagazineBox = new JComboBox (availableMagazineBoxItems);
        availableBookBox = new JComboBox (availableBookBoxItems);
        addBookButton = new JButton ("Agregar");
        addMagazineButton = new JButton ("Agregar");
        bookListLabel = new JLabel ("Listado de Libros");
        magazineListLabel = new JLabel ("Listado de Revistas");
        selectionPanelLabel = new JLabel ("Seleccione los Items para Prestar");
        showListButton = new JButton("Mostrar Lista");
        emptyListButton = new JButton("Vaciar Lista");
        lendButton = new JButton("Prestamo");
        profileButton = new JButton("Perfil");

        //add action listeners
        addBookButton.addActionListener(this);
        addMagazineButton.addActionListener(this);
        showListButton.addActionListener(this);
        emptyListButton.addActionListener(this);


        //adjust size and set layout
        setPreferredSize (new Dimension (309, 306));
        setLayout (null);

        //add components
        add (availableMagazineBox);
        add (availableBookBox);
        add (addBookButton);
        add (addMagazineButton);
        add (bookListLabel);
        add (magazineListLabel);
        add (selectionPanelLabel);
        add (showListButton);
        add (emptyListButton);
        add (lendButton);
        add (profileButton);

        //set component bounds (only needed by Absolute Positioning)
        availableMagazineBox.setBounds (10, 120, 160, 25);
        availableBookBox.setBounds (10, 70, 160, 25);
        addBookButton.setBounds (185, 70, 90, 25);
        addMagazineButton.setBounds (185, 120, 90, 25);
        bookListLabel.setBounds (10, 40, 105, 25);
        magazineListLabel.setBounds (10, 95, 130, 25);
        selectionPanelLabel.setBounds (55, 15, 200, 25);
        showListButton.setBounds(10, 155,110,25);
        emptyListButton.setBounds(10,190, 110,25);
        lendButton.setBounds(10, 225, 110, 25);
        profileButton.setBounds(185, 190, 90,25);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton){
            bookList.add((String) availableBookBox.getSelectedItem());
        }
        if (e.getSource() == addMagazineButton){
            magazineList.add((String) availableMagazineBox.getSelectedItem());
        }
        if (e.getSource() == showListButton){
            showList();
        }if (e.getSource() == emptyListButton){
            clearList();
        }
    }
    public void clearList(){
        bookList.clear();
        magazineList.clear();
    }
    public void showList(){
        JOptionPane.showMessageDialog(this, bookList + "," + magazineList);
    }
    public JButton getProfileButton(){
        return profileButton;
    }
    public JButton getLendButton(){
        return lendButton;
    }
    public ArrayList<String> getBookList(){
        return bookList;
    }
    public ArrayList<String> getMagazineList(){
        return magazineList;
    }
}