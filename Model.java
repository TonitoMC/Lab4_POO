import java.io.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Loan> loanList;
    private ArrayList<User> userList;
    private User loginUser;
public Model(){
    userList = new ArrayList<User>();
    loanList = new ArrayList<Loan>();
}
    public void setStore(String store){
    loginUser.setStore(store);
    }
    public void readCSV(){
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<String> tempList = new ArrayList<>();
                for (String field : data) {
                    tempList.add(field);
                }
                if (tempList.get(0).equals("y")){
                    userList.add(new PremiumUser(tempList.get(1), tempList.get(2), tempList.get(3), tempList.get(4), Integer.parseInt(tempList.get(5))));
                } else {
                    userList.add(new BaseUser(tempList.get(1), tempList.get(2), tempList.get(3), Integer.parseInt(tempList.get(4))));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("loans.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<String> tempList = new ArrayList<>();
                for (String field : data) {
                    tempList.add(field);
                }
                if (tempList.get(0).equals("y")){
                    String currentUsername = tempList.get(1);
                    String currentDeliveryTime = tempList.get(2);
                    String currentDeliveryAddress = tempList.get(3);
                    ArrayList<String> itemList = new ArrayList<String>();
                    for (int i = 5; i < tempList.size() + 5; i++){
                        itemList.add(tempList.get(i));
                    }
                    loanList.add(new PremiumLoan(currentUsername, currentDeliveryTime, currentDeliveryAddress, itemList));
                } else {
                    String currentUsername = tempList.get(1);
                    String currentStore = tempList.get(2);
                    ArrayList<String> itemList = new ArrayList<String>();
                    for (int i  = 4; i < tempList.size() + 4; i++){
                        itemList.add(tempList.get(i));
                    }
                    loanList.add(new BaseLoan(currentUsername, currentStore, itemList));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public boolean isPremium(){
    return loginUser.getPremium();
}
public boolean login(String username, String password){
    for (User currentUser : userList){
        if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)){
            loginUser = currentUser;
            return true;
        }
    }
    return false;
}
public boolean loan(ArrayList<String> bookList, ArrayList<String> magazineList){
    Loan currentLoan = loginUser.lend(bookList, magazineList);
    if (currentLoan != null){
        loanList.add(currentLoan);
        return true;
    } return false;
}
public boolean signup(String username, String password, boolean premium) {
    for (User currentUser : userList) {
        if (currentUser.getUsername().equals(username)) {
            return false;
        }
    }
    if (premium) {
        PremiumUser newPremiumUser = new PremiumUser(username, password);
        userList.add(newPremiumUser);
        loginUser = newPremiumUser;
        return true;
    } else {
        BaseUser newBaseUser = new BaseUser(username, password);
        userList.add(newBaseUser);
        loginUser = newBaseUser;
        return true;
    }
}
}