import java.util.ArrayList;

public class Customer {

    private String name;
    private int customerID;
    private ArrayList<Account> accounts = new ArrayList<>();     // List with accounts
    private static int cntCustomerID = 400000;

    Customer() {                 // no-arg constructor
        customerID = ++cntCustomerID;
        name = "noname";
    }

    Customer(String name) {      // parameterised constructor
        this();                  // invokes no-arg constructor Customer()
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
