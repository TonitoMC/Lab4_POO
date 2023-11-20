import java.util.ArrayList;

public class PremiumLoan implements Loan{
    private String user;
    private ArrayList<String> itemList;
    private String deliveryTime;
    private String deliveryAddress;
    private int returnIn;
    public PremiumLoan(String username, ArrayList<String> inputBookList, ArrayList<String> inputMagazineList, String deliveryTime, String deliveryAddress) {
        this.itemList = new ArrayList<String>();
        this.user = username;
        itemList.addAll(inputBookList);
        itemList.addAll(inputMagazineList);
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.returnIn = 50;
    }
    public PremiumLoan(String username, String deliveryTime, String deliveryAddress, ArrayList<String> inputItemList) {
        this.itemList = inputItemList;
        this.user = username;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.returnIn = 30;
    }
    @Override
    public String getString() {
        StringBuilder builder = new StringBuilder();
        for (String item : itemList){
            builder.append(item).append(",");
        }
        return "y," + user + "," + deliveryTime + "," + deliveryAddress + "," + returnIn + "," + builder.toString();
    }
}
