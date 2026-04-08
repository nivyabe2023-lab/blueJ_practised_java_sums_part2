import java.util.Scanner;
public class Bank_program{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000;

        while(true){
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();
                    balance += depositAmount;
                    System.out.println("Amount deposited successfully.");
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    if(withdrawAmount > balance){
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("Amount withdrawn successfully.");
                    }
                    break;
                case 3:
                    System.out.println("Current balance: " + balance);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}