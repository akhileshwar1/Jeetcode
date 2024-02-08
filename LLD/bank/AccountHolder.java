import java.util.List;
import Bank.User;

class AccountHolder extends User{

    protected boolean isAccountHolder;
    protected List<BankAccount> accs;

    public AccountHolder(String name, int id){
        super(name, id);
        this.isAccountHolder = true;
    }

    public boolean addAccount(BankAccount acc){
        this.accs.add(acc);
        return true;
    }

}


