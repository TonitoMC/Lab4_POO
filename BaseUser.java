import java.util.ArrayList;

public class BaseUser implements User{
    private boolean premium = false;
    private String username;
    private String password;
    private String store;
    private int bookNumber;
    final int maxBooks = 3;
    private String preferredStore;
    public BaseUser(String username, String password){
        this.username = username;
        this.password = password;
    }
    public BaseUser(String username, String password, String store, int bookNumber){
        this.username = username;
        this.password = password;
        this.store = store;
        this.bookNumber = bookNumber;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return username;
    }

    public boolean getPremium() {
        return premium;
    }

    public BaseLoan lend(ArrayList<String> inputBookList, ArrayList<String> inputMagazineList){
        BaseLoan newLoan = new BaseLoan(username, inputBookList, inputMagazineList, preferredStore);
        return newLoan;
    }
    public void setStore(String store){
    this.store = store;
    }
    public void giveBack(){

    }
    public String getStore(){
        return store;
    }
    public int getBookNumber(){
        return bookNumber;
    }
    public String getPassword() {
        return password;
    }
}
