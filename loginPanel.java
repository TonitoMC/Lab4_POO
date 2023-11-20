import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class loginPanel extends JPanel {
    private JLabel welcomeLabel;
    private JButton registerButton;
    private JTextField userTextField;
    private JTextField passwordTextField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JCheckBox premiumCheckbox;

    public loginPanel() {
        //construct components
        welcomeLabel = new JLabel ("Bienvenido al Programa");
        registerButton = new JButton ("Nuevo Usuario");
        userTextField = new JTextField (5);
        passwordTextField = new JTextField (5);
        userLabel = new JLabel ("Usuario");
        passwordLabel = new JLabel ("Contraseña");
        loginButton = new JButton ("Acceder");
        premiumCheckbox = new JCheckBox("Plan Premium");

        //adjust size and set layout
        setPreferredSize (new Dimension(309, 306));
        setLayout (null);
        setVisible(true);

        //add components
        add (welcomeLabel);
        add (registerButton);
        add (userTextField);
        add (passwordTextField);
        add (userLabel);
        add (passwordLabel);
        add (loginButton);
        add (premiumCheckbox);

        //set component bounds (only needed by Absolute Positioning)
        welcomeLabel.setBounds (70, 20, 140, 25);
        registerButton.setBounds (50, 210, 175, 25);
        userTextField.setBounds (50, 75, 175, 25);
        passwordTextField.setBounds (50, 125, 175, 25);
        userLabel.setBounds (50, 50, 45, 25);
        passwordLabel.setBounds (50, 100, 70, 25);
        loginButton.setBounds (50, 175, 175, 25);
        premiumCheckbox.setBounds(55,152,115,20);
    }
    public JButton getRegisterButton(){
        return registerButton;
    }
    public JButton getLoginButton(){
        return loginButton;
    }
    public boolean getPremium(){
        return premiumCheckbox.isSelected();
    }
    public String getUsername(){
        return userTextField.getText();
    }
    public String getPassword(){
        return passwordTextField.getText();
    }
    public void addActionListener(ActionListener listener){
        loginButton.addActionListener(listener);
        registerButton.addActionListener(listener);
    }
}