import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PremiumPanel extends JPanel {
    private JComboBox deliveryTimeBox;
    private JLabel deliveryTimeLabel;
    private JTextField adressTextField;
    private JLabel addressLabel;
    private JButton changePasswordButton;
    private JTextField desiredPasswordBox;
    private JLabel premiumProfileLabel;
    private JButton goToLoanButton;

    public PremiumPanel() {
        //construct preComponents
        String[] deliveryTimeBoxItems = {"AM", "PM"};

        //construct components
        deliveryTimeBox = new JComboBox(deliveryTimeBoxItems);
        deliveryTimeLabel = new JLabel("Horario de Entrega");
        adressTextField = new JTextField(5);
        addressLabel = new JLabel("Direccion");
        changePasswordButton = new JButton("Cambiar Contraseña");
        desiredPasswordBox = new JTextField(5);
        premiumProfileLabel = new JLabel("Perfil");
        goToLoanButton = new JButton("Ir a Prestamos");

        //adjust size and set layout
        setPreferredSize (new Dimension (309, 306));
        setLayout(null);

        //add components
        add(deliveryTimeBox);
        add(deliveryTimeLabel);
        add(adressTextField);
        add(addressLabel);
        add(changePasswordButton);
        add(desiredPasswordBox);
        add(premiumProfileLabel);
        add(goToLoanButton);

        //set component bounds (only needed by Absolute Positioning)
        deliveryTimeBox.setBounds(135, 80, 50, 25);
        deliveryTimeLabel.setBounds(25, 80, 115, 25);
        adressTextField.setBounds(90, 40, 175, 25);
        addressLabel.setBounds(25, 40, 60, 25);
        changePasswordButton.setBounds(60, 160, 165, 25);
        desiredPasswordBox.setBounds(60, 125, 165, 25);
        premiumProfileLabel.setBounds(125, 15, 35, 25);
        goToLoanButton.setBounds(60, 200, 165, 25);
    }
    public JButton getGoToLoanButton(){
        return goToLoanButton;
    }
}