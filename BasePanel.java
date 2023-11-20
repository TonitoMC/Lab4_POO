import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BasePanel extends JPanel {
    private JComboBox storeBox;
    private JLabel storeLabel;
    private JButton changePasswordButton;
    private JTextField desiredPasswordBox;
    private JLabel premiumProfileLabel;
    private JButton goToLoanButton;
    private JButton confirmStoreButton;

    public BasePanel() {
        //construct preComponents
        String[] storeBoxItems = {"Sucursal1", "Sucursal2"};

        //construct components
        storeBox = new JComboBox(storeBoxItems);
        storeLabel = new JLabel("Sucursal");
        changePasswordButton = new JButton("Cambiar Contraseña");
        desiredPasswordBox = new JTextField(5);
        premiumProfileLabel = new JLabel("Perfil");
        goToLoanButton = new JButton("Ir a Prestamos");
        confirmStoreButton = new JButton("OK");

        //adjust size and set layout
        setPreferredSize (new Dimension (309, 306));
        setLayout(null);

        //add components
        add(storeBox);
        add(storeLabel);
        add(changePasswordButton);
        add(desiredPasswordBox);
        add(premiumProfileLabel);
        add(goToLoanButton);
        add(confirmStoreButton);

        //set component bounds (only needed by Absolute Positioning)
        storeBox.setBounds(20, 65, 130, 25);
        storeLabel.setBounds(20, 40, 60, 25);
        changePasswordButton.setBounds(60, 160, 165, 25);
        desiredPasswordBox.setBounds(60, 125, 165, 25);
        premiumProfileLabel.setBounds(125, 15, 35, 25);
        goToLoanButton.setBounds(60, 200, 165, 25);
        confirmStoreButton.setBounds(155,65,55,25);
    }
    public JButton getConfirmStoreButton(){
        return confirmStoreButton;
    }
    public String getDesiredStore(){
        return (String) storeBox.getSelectedItem();
    }
    public JButton getGoToLoanButton() {
        return goToLoanButton;
    }
}