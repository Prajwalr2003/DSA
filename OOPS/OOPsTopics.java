import java.util.*;
import java.lang.Math;

// Interface
interface PaymentMethod{
    void processTransaction(double amount, String recipientAddress);
}

class UPI implements PaymentMethod{
    String upiId;
    private double balance;
    public UPI(String upiId, double balance){
        this.upiId = upiId;
        this.balance = balance;
    }

    @Override
    public void processTransaction(double amount, String recipientUPI){
        if(balance < amount){
            System.out.println("Insufficient Balance");
            return;
        }

        System.out.println("Processing transaction.....");
        System.out.println("From UPI ID : "+upiId);
        System.out.println("To UPI ID : "+recipientUPI);
        balance -= amount;
        System.out.println("Transaction of "+amount+" has been successful");
        System.out.println("Transaction Reference Id : "+UUID.randomUUID().toString());
    }

    double checkBalance(){
        return balance;
    }
}

class CreditCard implements PaymentMethod{
    String accountNumber;
    double balance;
    public CreditCard(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void processTransaction(double amount, String recipientAccountNumber){
        if(balance < amount){
            System.out.println("Insufficient Balance");
            return;
        }

        System.out.println("Processing transaction.....");
        System.out.println("From Bank Account : "+accountNumber);
        System.out.println("To Bank Account : "+recipientAccountNumber);
        balance -= amount;
        System.out.println("Transaction of "+amount+" has been successful");
        System.out.println("Transaction Reference Id : "+UUID.randomUUID().toString());
    }

    double checkBalance(){
        return balance;
    }
}

// Abstraction
abstract class ATM{
    private String bank;
    public ATM(String bank){
        this.bank=bank;
    }

    public void displayWelcomeMsg(){
        System.out.println("Welcome to "+bank+" ATM.");
    }

    abstract void validateCard(String cardNumber, String pin);
    abstract void performTransaction(String transactionType, double amount);
    abstract double checkBalance();
}

class BankATM extends ATM{
    private double balance;
    private String cardNumber;
    private String pin;
    public BankATM(String bank, String cardNumber, String pin, double amount){
        super(bank);
        this.cardNumber=cardNumber;
        this.pin = pin;
        this.balance=amount;
    }

    @Override
    void validateCard(String cardNumber, String pin){
        if(this.cardNumber.equals(cardNumber) && this.pin.equals(pin)){
            System.out.println("ATM Validated");
        }else{
            System.out.println("Sorry, ATM is not valid");
        }
    }

    @Override
    void performTransaction(String transactionType, double amount){
        switch(transactionType.toLowerCase()){
            case "withdraw":
                if(balance < amount){
                    System.out.println("Insufficient Balanace");
                    return;
                }
                balance-=amount;
                System.out.println(amount+" Withdraw successful");
                break;

            case "deposit":
                balance+=amount;
                System.out.println(amount+" Deposit successful");
                break;

            default:
                System.out.println("Invalid Transaction Type");
        }
    }

    double checkBalance(){
        return balance;
    }
}

// Method Overloading
class ManageUser{
    void addUser(String userId, String name){
        System.out.println("User added successfully");
    }

    void addUser(String userId, String name, String gender){
        System.out.println("User added successfully");
    }

    void addUser(String userId, String name, String gender, String DOB){
        System.out.println("User added successfully");
    }
}

// Method Overriding & Inheritance
class User{
    private String email;
    private String password;
    public User(String email, String password){
        this.email=email;
        this.password=password;
    }

    void dashboard(){
        System.out.println("Welcome to the Ecommerce App");
    }
}

class Customer extends User{
    public Customer(String email, String password){
        super(email, password);
    }

    @Override
    void dashboard(){
        System.out.println("Can Browse Products, Add Products to Cart, Place Orders");
    }
}

class Seller extends User{
    public Seller(String email, String password){
        super(email, password);
    }

    @Override
    void dashboard(){
        System.out.println("Add products, Edit products, Sees Sales Report, etc");
    }
}

// Encapsulation
class BankAccount{
    public String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    void deposit(double amount){
        balance += amount;
    }

    void withdraw(double amount){
        if(balance < amount){
            System.out.println("Insufficient Balance");
            return;
        }

        balance -= amount;
    }

    double getBalance(){
        return balance;
    }
}

public class OOPsTopics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // double amount = sc.nextDouble();
        // UPI phonePe = new UPI("abc@ybl", 4000);
        // phonePe.processTransaction(amount, "xyz@ybl");

        // System.out.println();

        // CreditCard SBI = new CreditCard("45257382049852", 50000.283);
        // SBI.processTransaction(amount, "82472639203948");

        // System.out.println();

        // System.out.println("PhonePe Balance : "+phonePe.checkBalance());
        // System.out.println("SBI Balance : "+SBI.checkBalance());

        // ATM sbi = new BankATM("State Bank of India", "39239749237", "32423", 5000);
        // sbi.displayWelcomeMsg();
        // sbi.validateCard("39239749237", "32423");
        // sbi.performTransaction("withdraw", amount);
        // System.out.println("Total Balance : "+sbi.checkBalance());

    }
}

