import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name ,initial balance and password:");

        String name = sc.nextLine();
        int balance = sc.nextInt();
        String password = sc.next();

        HDFCUser acc1 = new HDFCUser(name, password,balance);
        System.out.println("The account number of new SBI account: " + acc1.getAccN0());

        System.out.println("Enter the amount that you want to add");

        int money = sc.nextInt();

        acc1.addMoney(money);

        System.out.println("The new balance is "+acc1.checkBalance()); //need to check with checkbalance.

        System.out.println("withdrawn money");

        int amount =sc.nextInt();

        System.out.println("enter the password");

        String enteredPassword = sc.next();

        System.out.println(acc1.withDrawMoney(amount,enteredPassword));

        System.out.println("The interest for 10 years on " +acc1.checkBalance()+" will be Rs. "+acc1.calculateInterest(10));

    }
}