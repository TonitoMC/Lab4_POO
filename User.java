import java.util.ArrayList;

public interface User{
    Loan lend(ArrayList<String> inputBookList, ArrayList<String> inputMagazineList);
    String getPassword();
    String getUsername();
    boolean getPremium();
    void setStore(String store);
}