package Practice;

public class EncapsulationTest {


    private double balance;
    private String accountholder;

    //constructor
    public EncapsulationTest(double balance) {
       // this.accountholder = accountholder;
        this.balance = 0.0;
    }

    //getter method
    public double getBalance(){
        return balance;
    }

    //getter
    public void deposit(double amount){
        if(amount>0){
            balance = balance+amount;
            System.out.println(amount +  " Deposited successfully");
        } else {
            System.out.println("Deposit amount must be greater than zero");
        }
        }

    public static void main(String[] args) {
        EncapsulationTest et = new EncapsulationTest(500);
        et.deposit(500);
    }
}