import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {
    loginPanel loginPanel;
    selectionPanel selectionPanel;
    PremiumPanel premiumPanel;
    BasePanel basePanel;
    public View(){
        loginPanel = new loginPanel();
        selectionPanel = new selectionPanel();
        premiumPanel = new PremiumPanel();
        basePanel = new BasePanel();
        this.setTitle("Biblioteca");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300,300);
        this.setVisible(true);
        this.setLayout(null);
        showLoginPanel();
    }
    public void showPremiumPanel(){
        setContentPane(premiumPanel);
        revalidate();
        repaint();
    }
    public void showLoginPanel(){
        setContentPane(loginPanel);
        revalidate();
        repaint();
    }
    public void showSelectionPanel(){
        setContentPane(selectionPanel);
        revalidate();
        repaint();
    }
    public void showBasePanel(){
        setContentPane(basePanel);
        revalidate();
        repaint();
    }
    public JButton getRegisterButton(){
        return loginPanel.getRegisterButton();
    }
    public JButton getLoginButton(){
        return loginPanel.getLoginButton();
    }
    public void addActionListener(ActionListener listener){
        loginPanel.getLoginButton().addActionListener(listener);
        loginPanel.getRegisterButton().addActionListener(listener);
        basePanel.getGoToLoanButton().addActionListener(listener);
        premiumPanel.getGoToLoanButton().addActionListener(listener);
        selectionPanel.getProfileButton().addActionListener(listener);
        selectionPanel.getLendButton().addActionListener(listener);
    }
    public String getLoginUsername(){
        return loginPanel.getUsername();
    }
    public String getLoginPassword(){
        return loginPanel.getPassword();
    }
    public void popUp(String text){
        JOptionPane.showMessageDialog(this, text);
    }
    public boolean signupPremium(){
        return loginPanel.getPremium();
    }
    public JButton getBaseGoToLoanButton(){
        return basePanel.getGoToLoanButton();
    }
    public JButton getPremiumGoToLoanButton(){
        return premiumPanel.getGoToLoanButton();
    }
    public JButton getLendButton(){
        return selectionPanel.getLendButton();
    }
    public JButton getProfileButton(){
        return selectionPanel.getProfileButton();
    }
    public ArrayList<String> getBookList(){
        return selectionPanel.getBookList();
    }
    public ArrayList<String> getMagazineList(){
        return selectionPanel.getMagazineList();
    }
    public JButton getConfirmStoreButton(){
        return basePanel.getConfirmStoreButton();
    }
    public String getDesiredStore(){
        return basePanel.getDesiredStore();
    }
}