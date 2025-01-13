import java.util.Scanner;

class BankInfo {
    float Balance;
    int PIN;
    int accNo;
    String holderName;
    String accType;

    public void createPIN() {
        System.out.println("Create a pin : ");
        Scanner sc = new Scanner(System.in);
        PIN = sc.nextInt();
    }

    public void AccDetails() {
        System.out.println("Enter your Details to become a member : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Set Account Number : ");
        accNo = sc.nextInt();
        System.out.println("Set Holder Name : ");
        holderName = sc.next();
        System.out.println("Set Account Type : ");
        accType = sc.next();
    }

    public void cP() {
        System.out.println("Enter your PIN : ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();

        if (enteredpin != PIN) {
            System.out.println("Enter a valid PIN");
            cP();
        } else {
            menu();
        }
    }

    public void CheckPin() {
        AccDetails();
        createPIN();
        cP();
    }

    public void menu() {
        System.out.println("*** Banking Information System ***");
        System.out.println("1. Check Account Details ");
        // System.out.println("2. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposite Money");
        System.out.println("4. Exit");
        System.out.println("Enter your choice : ");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkAccDet();
        }

        // else if (opt == 2) {
        // checkBalance();
        // }

        else if (opt == 2) {
            withdrawMoney();
        }

        else if (opt == 3) {
            depositMoney();
        }

        else if (opt == 4) {
            System.out.println("Thank You !");
            return;
        }
    }

    public void checkAccDet() {
        System.out.println("Your Account details : ");
        System.out.println("Holder Name : " + holderName);
        System.out.println("Account Number : " + accNo);
        System.out.println("Account Type : " + accType);
        System.out.println("Current Balance : " + Balance);
        menu();
    }

    public void checkBalance() {
        System.out.println("Your current balance is : " + Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter your amount to withdraw : ");
        Scanner sc = new Scanner(System.in);
        float money = sc.nextFloat();

        if (money > Balance) {
            System.out.println("Sorry ! Insufficient Money");
            withdrawMoney();
        }

        else {
            Balance = Balance - money;
            System.out.println("Money withdrawal successful . Thank you !");
            menu();
        }
    }

    public void depositMoney() {
        System.out.println("Enter your amount to deposit : ");
        Scanner sc = new Scanner(System.in);
        float money = sc.nextInt();

        Balance = Balance + money;
        System.out.println("Money deposited successfully . Thank you !");
        menu();
    }
}

public class BankingInformationSystem {
    public static void main(String args[]) {

        BankInfo object = new BankInfo();
        object.CheckPin();
    }
}