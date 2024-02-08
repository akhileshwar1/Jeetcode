import java.util.List;

class BankAccount{

    protected long balance;

    protected boolean isActive;

    protected double accountNumber;

    public BankAccount(double no, long balance){
        this.accountNumber = no;
        this.balance = balance;
        this.isActive = true;
        this.accountNumber = Math.random();
    }

    public int withdraw(int amount){
        if (amount <= this.balance){
            return this.balance - amount;
        }
            else{
                return -1;
            }
    }

    public boolean deposit(int amount){
        if(isActive){
        this.balance = this.balance + amount;
        return true;
        }
        else{
            return false;
        }
    }
}
