import java.util.ArrayList;

public class BaseLoan implements Loan {
    private String username;
    private ArrayList<String> itemList;
    private String store;
    private int returnIn;

    public BaseLoan(String username, ArrayList<String> inputBookList, ArrayList<String> inputMagazineList, String store) {
        this.username = username;
        itemList.addAll(inputBookList);
        itemList.addAll(inputMagazineList);
        this.store = store;
    }
    public BaseLoan(String username, String store, ArrayList<String> itemList){
        this.username = username;
        this.itemList = itemList;
        this.store = store;
        this.returnIn = 30;
    }
    public String getString(){
        return "s";
    }
}