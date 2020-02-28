package dume_problem1;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI1 {
	
	static SecureRandom rand = new SecureRandom();
	static int randInt1 = rand.nextInt(10);
	static int randInt2 = rand.nextInt(10);
	
	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		askQuestion();
		int userResponse = readResponse();
		displayCorrectResponse(isAnswerCorrect(userResponse));
		displayIncorrectResponse(isAnswerCorrect(userResponse));
		
		}

	
	static void askQuestion() {
		System.out.printf("How much is %d times %d?\n",randInt1,randInt2);
	}
	
	static int readResponse() {
		Scanner myObj = new Scanner(System.in);
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
			System.out.println("Very Good!");
		}
		
	}
	
	static void displayIncorrectResponse(boolean answer) {
		if (answer == false) {
			System.out.println("No.Please try again.");	
			quiz();
		}
	}

}
