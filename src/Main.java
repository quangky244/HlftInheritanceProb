import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(new Customer("Father"), new Customer("Child")));
        ArrayList<Account> accounts = new ArrayList<>(Arrays.asList(new Account(50, customers.get(0)),
                new PocketMoneyAccount(50, customers.get(1), customers.get(0))));

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

        Customer ky = new Customer("quangKy");
        Account kyacc = new Account(2000, ky);
        System.out.println("\tcustomerID=" + ky.getCustomerID()+"\tName="+ky.getName());

    }
}
