package dume_problem2;

public class SavingsAccountTest {
	public static void main(String[] args) {
		SavingAccount saver1 = new SavingAccount("saver1",2000);
		SavingAccount saver2 = new SavingAccount("saver2",3000);
		SavingAccount.modifyInterestRate(0.04);
		System.out.println("Year 1");
		for (int i=0;i<12;i++) {
			saver1.calculateMonthlyInterest();
		}
		
		for (int i=0;i<12;i++) {
			saver2.calculateMonthlyInterest();
		}
		SavingAccount.modifyInterestRate(0.05);
		System.out.println("Year 2");
		for (int i=0;i<12;i++) {
			saver1.calculateMonthlyInterest();
		}
		
		for (int i=0;i<12;i++) {
			saver2.calculateMonthlyInterest();
		}
	}
}
