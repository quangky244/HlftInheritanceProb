public class Account {
    private int accountNumber;
    private double balance;
    private Customer customer;  // holds only one owner of account
    private static int cntAccountNumber = 100000;

    public Account() {
        accountNumber = ++cntAccountNumber;
        balance = 0;
    }

    public Account(double amount, Customer customer) {
        this();
        this.customer = customer;
        this.customer.addAccount(this);
        balance = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int transaction(double amount) {
        balance += amount;
        return 0;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

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

 import java.util.ArrayList;
         import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(new Customer("Father"), new Customer("Child")));
        ArrayList<Account> accounts = new ArrayList<>(Arrays.asList(new Account(50, customers.get(0)))));

        for (Customer customer : customers) {
            System.out.println("customerID=" + customer.getCustomerID() + "\tName=" + customer.getName() + ":");
            ArrayList<Account> accountsOfCustomer = customer.getAccounts();  // navigates from customer to account
            for (Account account : accountsOfCustomer) {
                System.out.println("\taccount number=" + account.getAccountNumber() + "\tbalance=" + account.getBalance() + ":");
                if (account.transaction(-100) == 0)
                    System.out.println("Transaction OK");
                else
                    System.out.println("Transaction not allowed. Balance would be negative.");
            }
        }
    }
}
