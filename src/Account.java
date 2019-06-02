public class Account {
    private int accountNumber;
    protected double balance;
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