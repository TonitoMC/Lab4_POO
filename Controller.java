import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Controller implements ActionListener {
    private View mainView;
    private Model mainModel;
    public Controller(View mainView, Model mainModel){
        this.mainModel = mainModel;
        this.mainView = mainView;
        mainView.addActionListener(this);
        mainModel.readCSV();
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == mainView.getLoginButton()){
            if (!mainView.getLoginUsername().isEmpty() && !mainView.getLoginPassword().isEmpty()) {
                if (mainModel.login(mainView.getLoginUsername(), mainView.getLoginPassword())) {
                    mainView.showSelectionPanel();
                } else {
                    mainView.popUp("Credenciales Incorrectas");
                }
            } else{
                mainView.popUp("Campos de texto vacios");
            }
        }
        if (e.getSource() == mainView.getRegisterButton()){
            if (!mainView.getLoginUsername().isEmpty() && !mainView.getLoginPassword().isEmpty()) {
                if (mainModel.signup(mainView.getLoginUsername(), mainView.getLoginPassword(), mainView.signupPremium())) {
                    if (mainView.signupPremium()) {
                        mainView.showPremiumPanel();
                        mainModel.writeCSV();
                    } else {
                        mainView.showBasePanel();
                        mainModel.writeCSV();
                    }
                } else {
                    mainView.popUp("Pruebe otro nombre de usuario");
                }
            } else {
                mainView.popUp("Campos de texto vacios");
            }
        }
        if (e.getSource() == mainView.getBaseGoToLoanButton()){
            mainView.showSelectionPanel();
        }
        if (e.getSource() == mainView.getPremiumGoToLoanButton()){
            mainView.showSelectionPanel();
        }
        if (e.getSource() == mainView.getProfileButton()){
            if (mainModel.isPremium()){
                mainView.showPremiumPanel();
            } else{
                mainView.showBasePanel();
            }
        }
        if (e.getSource() == mainView.getLendButton()){
            if(!mainView.getBookList().isEmpty() || !mainView.getMagazineList().isEmpty()) {
                if (mainModel.loan(mainView.getBookList(), mainView.getMagazineList())) {
                    mainView.popUp("Prestamo exitoso");
                } else {
                    mainView.popUp("Ha llegado al limite de libros");
                }
            } else{
                mainView.popUp("No ha seleccionado ningun item");
            }
        }
        if (e.getSource() == mainView.getConfirmStoreButton()){
            mainModel.setStore(mainView.getDesiredStore());
            mainModel.writeCSV();
        }
    }
}