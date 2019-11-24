package lab1.q1;

public class Main {

    public static void main(String[] args) {
	    Account A1122 = new Account(1122, 20000);
	    System.out.println(A1122);
	    A1122.withdraw(2500);
        System.out.println(A1122);
        A1122.deposit(3000);
        System.out.println("The balance now is " + A1122.getBalance());
        System.out.println("The monthly interest rate is " + A1122.getMonthlyInterestRate());
        System.out.println("This account was created on " + A1122.getDate());
    }
}
