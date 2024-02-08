import Bank.User;
import java.util.HashMap;
import java.util.List;

class BankManager extends User{

    protected boolean isManager;
    
    protected List<BankAccount> managedAccounts;

    public Manager(String name, int id){
        super(name, id);
        this.isManager = true;
    }

    public boolean closeAccount(int accNo){
        for (BankAccount acc: this.managedAccounts){
            if(accNo == acc.accountNumber){
                acc.isActive = false;
                return true;
            }
        }
        return false;
    }
}
        

