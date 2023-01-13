import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface {

    private String AccountNo;
    private String name;
    private int balance;
    private String password;
    private float rateofInterest;

    public SBIUser(String name, int balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.AccountNo = String.valueOf(UUID.randomUUID());
        this.rateofInterest = 6.6f;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getRateofInterest() {
        return rateofInterest;
    }

    public void setRateofInterest(float rateofInterest) {
        this.rateofInterest = rateofInterest;
    }

    @Override
    public int checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int money) {
        balance = balance+money;
        return "Successfully added money" + money + "your new balance is" + balance;
    }

    @Override
    public String withDrawMoney(int money, String enteredPassword) {

        if(Objects.equals(enteredPassword,password)){
            if(money > balance) return "Sorry bro! but less money";
            else{
                this.balance = this.balance - money;
                return "money has been withdrawn Rs " + money;
            }
        }
        else return "Wrong password";

    }

    @Override
    public float calculateInterest(int years) {
        return (balance * years * rateofInterest)/100;
    }
}
