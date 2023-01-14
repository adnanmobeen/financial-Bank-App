import java.util.Objects;
import java.util.UUID;

public class HDFCUser implements BankInterface {
    private String name;

    private String accN0;
    private String password;
    private static float rateofinterest;
    private int balance;

    public HDFCUser(String name, String password, int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;

        this.accN0 = String.valueOf(UUID.randomUUID());
        this.rateofinterest = 6.6f;
    }

    public String getAccN0() {
        return accN0;
    }

    @Override
    public int checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int money) {
        balance = balance + money;
        return money + " Rs. has been added";
    }

    @Override
    public String withDrawMoney(int money, String enteredpassword) {
        if(Objects.equals(password,enteredpassword)){
            if(money > balance) return "Sorry Bro! insufficient amount";
            else{
                balance = balance - money;
                return "Rs. " + money + " has been withdrawn.";
            }
        }
        else
        return "Wrong password!";
    }

    @Override
    public float calculateInterest(int years) {
        return (balance * rateofinterest * years)/100;
    }
}
