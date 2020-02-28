package dume_problem1;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI5 {
	
	static SecureRandom rand = new SecureRandom();
	static int randInt1;
	static int randInt2;
	static Scanner myObj = new Scanner(System.in);
	static int studentScore = 0;
	static int problemType;
	
	public static void main(String[] args) {
		quiz();
	}
	
	static void quiz() {
		studentScore = 0;
		boolean mixtureCheck = false;
		problemType = readProblemType() - 1;
		
		if(problemType == 4) {
			mixtureCheck = true;
		}
		int difficultyLvl = readDifficulty();
		for (int i=0; i<10;i++) {
			generateQuestionArgument(difficultyLvl);
			askQuestion();
			double userResponse = readResponse();
			displayCorrectResponse(isAnswerCorrect(userResponse, problemType));
			displayIncorrectResponse(isAnswerCorrect(userResponse, problemType));
			if (mixtureCheck == true) {
				problemType = 4;
			}
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
		switch(problemType) {
		case 0:
			System.out.printf("How much is %d plus %d?\n",randInt1,randInt2);
			break;
		case 1:
			System.out.printf("How much is %d times %d?\n",randInt1,randInt2);
			break;
		case 2:
			System.out.printf("How much is %d minus %d?\n",randInt1,randInt2);
			break;
		case 3:
			System.out.printf("How much is %d divided by %d?\n",randInt1,randInt2);
			break;
		case 4:
			problemType = rand.nextInt(4);
			askQuestion();
			break;
		}
		
	}
	
	static double readResponse() {
		double userResponse = myObj.nextDouble();
		return userResponse;
		
	}
	
	static boolean isAnswerCorrect(double userResponse, int problemType){
		boolean value = false;
		switch(problemType) {
		case 0:
			if((randInt1 + randInt2) == userResponse){
				value = true;
			}else {
				value = false;
			}
			break;
		case 1:
			if((randInt1 * randInt2) == userResponse){
				value = true;
			}else {
				value = false;
			}
			break;
		case 2:
			if((randInt1 - randInt2) == userResponse){
				value = true;
			}else {
				value = false;
			}
			break;
		case 3:
			double double1 = randInt1;
			double double2 = randInt2;
			if((double1 / double2) == userResponse){
				value = true;
			}else {
				value = false;
			}
			break;
		}

		return value;
	}
	
	static void displayCorrectResponse(boolean answer) {
		if (answer == true){
			studentScore+= 10;
			switch (rand.nextInt(4)) {
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
			switch (rand.nextInt(4)) {
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
	
	static void generateQuestionArgument(int difficultyLvl) {
		randInt1 = rand.nextInt((int) Math.pow(10, difficultyLvl));
		randInt2 = rand.nextInt((int) Math.pow(10, difficultyLvl));		
	}
	
	static int readDifficulty() {
		System.out.println("Enter a difficulty level between 1 and 4");
		return myObj.nextInt();
	}
	
	static int readProblemType() {
		System.out.println("Pick your problem type. \n1 - Addition \n2 - Multiplication \n3 - Subtraction \n4 - Division \n5 - Mixture of all");
		return myObj.nextInt();
	}

}
