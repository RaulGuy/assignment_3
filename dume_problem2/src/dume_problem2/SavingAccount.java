package dume_problem2;

public class SavingAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	private String name;
	public SavingAccount(String name, double savingsBalance){
		this.name = name;
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest() {
		double monthlyInterest = savingsBalance*annualInterestRate/12;
		savingsBalance+= monthlyInterest;
		System.out.printf("| %s | Monthly Interest | %.2f\t| Savings Balance | %.2f\t|\n" ,name, monthlyInterest,savingsBalance);
	}
	
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}

}
