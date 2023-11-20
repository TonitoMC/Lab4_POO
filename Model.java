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
    ArrayList<BaseUser> baseUserList = getBaseUserList();
    for (BaseUser user : baseUserList){
        if (user.getUsername().equals(loginUser.getUsername())){
            user.setStore(store);
        }
    }
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
                    for (int i = 5; i < tempList.size(); i++){
                        itemList.add(tempList.get(i));
                    }
                    loanList.add(new PremiumLoan(currentUsername, currentDeliveryTime, currentDeliveryAddress, itemList));
                } else {
                    String currentUsername = tempList.get(1);
                    String currentStore = tempList.get(2);
                    ArrayList<String> itemList = new ArrayList<String>();
                    for (int i  = 4; i < tempList.size(); i++){
                        itemList.add(tempList.get(i));
                    }
                    loanList.add(new BaseLoan(currentUsername, currentStore, itemList));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCSV(){
    ArrayList <PremiumUser> premiumUserList = getPremiumUserList();
    ArrayList<BaseUser> baseUserList = getBaseUserList();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.csv"))) {
            for (PremiumUser currentPremiumUser : premiumUserList){
                bw.write("y," + currentPremiumUser.getUsername() + "," + currentPremiumUser.getPassword() + ","
                        + currentPremiumUser.getDeliveryTime() + "," + currentPremiumUser.getDeliveryAddress() + ","
                + currentPremiumUser.getDeliveryTime() + "," + currentPremiumUser.getBookNumber() + ",");
                bw.newLine();
            }
            for (BaseUser currentBaseUser : baseUserList){
                bw.write("n," + currentBaseUser.getUsername() + "," + currentBaseUser.getPassword() + "," + currentBaseUser.getStore() +
                        "," + currentBaseUser.getBookNumber() + ",");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.csv"))) {
            for (Loan currentLoan : loanList){
                bw.write(currentLoan.getString());
                bw.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<PremiumUser> getPremiumUserList(){
    ArrayList<PremiumUser> tempList = new ArrayList<>();
    for (User currentUser: userList){
        if (currentUser.getClass().getSimpleName().equals("PremiumUser")){
            tempList.add((PremiumUser) currentUser);
        }
    }
    return tempList;
    }
    public ArrayList<BaseUser> getBaseUserList(){
    ArrayList<BaseUser> tempList = new ArrayList<>();
    for (User currentUser : userList){
        if (currentUser.getClass().getSimpleName().equals("BaseUser")){
            tempList.add((BaseUser) currentUser);
        }
    }
    return tempList;
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