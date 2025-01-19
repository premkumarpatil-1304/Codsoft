import java.util.Scanner;

class BankAccount{
    private double balance;


    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //method to deposit money

    public void deposit(double amount){
        if(amount>0){
            balance=balance+amount;
            System.out.println("successfully deposited: $"+amount);
        }
        else{
            System.out.println("invalid amount");
        }
    }

    //withdraw money

    public boolean withdraw(double amount){
        if(amount>0 && amount <=balance){
            balance=balance-amount;
            System.out.println("successfully withdrawn: $"+amount);
            return true;
        }
        else if(amount>balance){
            System.out.println("insufficient balance");
            return false;
        }
        else{
            System.out.println("invalid withdrawal amount");
            return false;
        }
    }
    //method to check the balance
    public double getBalance(){
        return balance;
    }
}

//class to represent ATM machine
class ATMachine{
    private BankAccount account;

    // Constructor to link ATM with a bank account
    public ATMachine(BankAccount account) {
        this.account = account;
    }

    //method to display users input and choices;
    public void start(){
        Scanner sc= new Scanner(System.in);

        while(true){
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice=sc.nextInt();

            switch (choice){
                case 1://deposiitt
                    System.out.println("enter the amount to deposit;");
                    double depositAmount=sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2: //withdraw;
                    System.out.println("enter the smount to withdraw;");
                    double withdrawAmount=sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3://check balance
                    System.out.println("your current balance is: $"+account.getBalance());
                    break;
                case 4://EXIT;
                    System.out.println("thankyou for using the ATM services");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice please try again");



            }


        }
    }
}



public class   AtmInterface {
    public static void main(String args[]){

        //initialoizing the bank amount wuth an initial amount
        BankAccount useraccount=new BankAccount(2000.0);
        //create an ATM instance linked to users
        ATMachine atm= new ATMachine(useraccount);

        //start the atm
        atm.start();
    }

}
