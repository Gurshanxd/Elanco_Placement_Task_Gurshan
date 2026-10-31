import java.io.IOException;
import java.util.Scanner;

public class UserSearchAndFilter {
	//this class holds the main activities the user end can do
	/*
	 * The user should be allowed to search tick sightings based on time range and location
	 * Additionally, they should also be able to filter sightings by time and range
	 * 
	 * I'll also allow the user to search tick sightings by city and species
	 * 
	 * When outputting the results, the data should be shown in formats such as numbers of sightings per region, and so on
	 */
	
	Scanner scan = new Scanner(System.in);
	InputHandler inputHandle = new InputHandler();
	ElancoApi api = new ElancoApi();
	
	//time range
	public void timeCasesDsiplay() {
		System.out.println("Please enter the first date you wish to use for the filter in the format of yyyy-mm-dd: ");
		String dateOne = scan.next();
		
		//validate date
		inputHandle.userDateValidation(dateOne);
		
		
		String cases = null;
		try {
			cases = api.getTickSightingsDate(dateOne);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(cases);
	}
	
	//location
	public void locationCasesDisplay() {
		System.out.println("Please select a city you wish to filter cases for: ");
		String userCity = "";
		userCity = scan.next();
		
		//validate input
		userCity = inputHandle.userCityValidation(userCity);
		System.out.println("Your corrected city name: " + inputHandle.userCityValidation(userCity));
		
		//body of the json data for the city filtered data
		String cityBody = "";
		
		//now that the location name is validated, it is time to extract the cases based on the city using the API method
		try {
			 cityBody =  api.getTickSightingsCity(userCity);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(cityBody);
	}
}
