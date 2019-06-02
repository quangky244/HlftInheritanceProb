public class PocketMoneyAccount extends Account {
    private Customer guardian;

    PocketMoneyAccount(double ammount, Customer customer, Customer guardian) {
        super(ammount, customer);
        this.guardian = guardian;
    }
    public int transaction(double ammount){
        if (balance + ammount >= 0){
            balance += ammount;
            return 0;
        }
        else {
            return -1;
        }
    }
}
