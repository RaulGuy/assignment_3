package dume_problem1;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI3 {
	
	static SecureRandom rand = new SecureRandom();
	static int randInt1 = rand.nextInt(10);
	static int randInt2 = rand.nextInt(10);
	static Scanner myObj = new Scanner(System.in);
	static int studentScore = 0;
	
	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		studentScore = 0;
		for (int i=0; i<10;i++) {
			randInt1 = rand.nextInt(10);
			randInt2 = rand.nextInt(10);
			
			
			askQuestion();
			int userResponse = readResponse();
			displayCorrectResponse(isAnswerCorrect(userResponse));
			displayIncorrectResponse(isAnswerCorrect(userResponse));
		}
		displayCompletionMessage();
		
		System.out.println("Start a new problem set?(Enter yes or no)");
		Scanner myObj = new Scanner(System.in);
		String endPrgm = myObj.nextLine();
		if (endPrgm.equals("yes")) {
			System.out.println("A new problem set has begun.");
			quiz();
		} else {
			System.out.println("Goodbye!");
		}
		
		}

	
	static void askQuestion() {
		System.out.printf("How much is %d times %d?\n",randInt1,randInt2);
	}
	
	static int readResponse() {
		int userResponse = myObj.nextInt();
		return userResponse;
		
	}
	
	static boolean isAnswerCorrect(int userResponse){
		if((randInt1 * randInt2) == userResponse){
			return true;
		}else {
			return false;
		}
		
	}
	static void displayCorrectResponse(boolean answer) {
		if (answer == true){
			int responseNum = rand.nextInt(4);
			studentScore+= 10;
			switch (responseNum) {
			case 0:
				System.out.println("Very Good!");
				break;
			case 1:
				System.out.println("Excellent!");
				break;
			case 2:
				System.out.println("Nice Work!");
				break;
			case 3:
				System.out.println("Keep up the good work!");
				break;
			}
			
		}
		
	}
	
	static void displayIncorrectResponse(boolean answer) {
		if (answer == false) {
			int responseNum = rand.nextInt(4);
			switch (responseNum) {
			case 0:
				System.out.println("Incorrect.");
				break;
			case 1:
				System.out.println("Wrong.");
				break;
			case 2:
				System.out.println("Don't give up!");
				break;
			case 3:
				System.out.println("No. Keep trying.");
				break;
			}
		}
	}
	
	static void displayCompletionMessage(){
		if (studentScore >= 75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
		
		
	}

}
