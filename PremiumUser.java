import java.util.ArrayList;

public class PremiumUser implements User{
    private boolean premium = true;
    private String username;
    private String password;
    private int bookNumber;
    final int maxBooks = 5;
    private String deliveryTime;
    private String deliveryAddress;
    public PremiumUser(String username, String password){
        this.username = username;
        this.password = password;
        this.bookNumber = 0;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getBookNumber() {
        return bookNumber;
    }
    public String getDeliveryTime(){
        return deliveryTime;
    }

    public PremiumUser(String username, String password, String deliveryTime, String deliveryAddress, int bookNumber){
        this.username = username;
        this.password = password;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.bookNumber = bookNumber;
    }
    @Override
    public PremiumLoan lend(ArrayList<String> inputBookList, ArrayList<String> inputMagazineList){
        if (bookNumber + inputBookList.size() <= maxBooks){
            PremiumLoan newLoan = new PremiumLoan(username, inputBookList, inputMagazineList, deliveryTime, deliveryAddress);
            return newLoan;
        }
        else {
            return null;
        }
    }
    public boolean getPremium() {
        return premium;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public String getUsername(){
        return username;
    }
    public void giveBack(){

    }
    public void setStore(String store){
        System.out.println("a");
    }
}