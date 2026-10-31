import java.util.Scanner;
public class InputHandler {
	//this class will show different methods for when the user has an input to validate
	
	Scanner scan = new Scanner (System.in);
	
	//1st, menu input handling
	//validate whether the input is an integer, not integer or not a valid integer
	//I find recursive methods to be easiest for input validation
	public int menuValidation(int input) {
		//1st check - if integer is not a valid num, as it can only be 1 between 3
		if(input <= 0 || input > 2) {
			//ask for input again and restart method
			System.out.println("Please try again, your input is not a number between 1 to 2: ");
			input = scan.nextInt();
			menuValidation(input);
		}
		
		//if it reached this part then it is likely a valid integer
		else {
			//for testing purposes 
			//System.out.println("Valid Integer");
		}
		
		return input;
	}
	
	//2nd, validate userSearch input for the second user option menu
	public int userSearchValidation(int input) {
		if(input <= 0 || input > 2) {
			//restart method
			System.out.println("Please try again, your input is not a 1 or 2: ");
			input = scan.nextInt();
			userSearchValidation(input);
		}
		
		else {
			//for testing purposes 
			//System.out.println("Valid Option");
		}
		
		return input;
	}
	
	//Validate city input for filtering the location option
	public String userCityValidation(String userCity) {
		String validatedUserCity = "";
		
		//Convert the parameter to all lower case characters
		validatedUserCity = userCity.toLowerCase();
		
		//find the first character and turn it into a capital letter
		String firstCharacter = validatedUserCity.substring(0,1).toUpperCase();
		
		//merge the string variables together to form the corrected city for the endpoint
		validatedUserCity = (firstCharacter) + (userCity.substring(1, userCity.length()).toLowerCase());
		
		return validatedUserCity;
	}
	
	//validate date input for the date option
	public String userDateValidation(String date) {
		//date provided by the user will be in the format of yyyy/mm/dd
		//check 1 - check if the string provided is null or not to prevent errors with .length
		if(date.isBlank() || date.isEmpty() || date == null) {
			//reiterate method with new date
			System.out.println("Please enter the date in the field: ");
			date = scan.next();
			userDateValidation(date);
		}
		
		//check 2 - check if String contains anything that isn't characters (except "-") by looping through a  data structure
		Character [] dateBreakdown = new Character [date.length()];
		
		//I'll loop into each character in the string of the date
		for(int i = 0; i < date.length(); i++) {
			dateBreakdown[i] = date.charAt(i);
			
			//check 3 - check if an individual character is not following the rule 
			if((!Character.isDigit(dateBreakdown[i])) && (dateBreakdown[i] != '-' )) {
				//restart method
				System.out.println("Please enter the date using the format I've stated (yyyy/mm/dd): ");
				date = scan.next();
				userDateValidation(date);
			}
		}
		//Now that the date is correct, I need to re-assemble it
		String evaluatedDate = "";
		for (Character character : dateBreakdown) {
			evaluatedDate = evaluatedDate + character;
		}
		//test
		//System.out.println("Updated date: " + evaluatedDate);
		return evaluatedDate;
	}
}
