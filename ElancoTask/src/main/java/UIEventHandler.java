import java.io.IOException;
import java.util.Scanner;

public class UIEventHandler {
	//this class handles the event chain that happens in the console
	MenuUI ui = new MenuUI();
	ElancoApi api = new ElancoApi();
	Scanner scan = new Scanner(System.in);
	InputHandler inputHandle = new InputHandler();
	UserSearchAndFilter searchAndFilter = new UserSearchAndFilter();
	
	public void mainEvent(int input) {
        //1 - Search and filter tick sightings
        if(input == 1) {
        	//display options between searching and filtering cases or just displaying all cases
        	ui.userSearch();
        	
        	//input
        	int searchAndFilterInput = scan.nextInt();
        	
        	//1 = go deeper into the search and filter options
        	if(searchAndFilterInput == 1) {
        		//display options
        		ui.searchAndFilterOption();
        		
        		//input
        		int timeOrLocInput = scan.nextInt();
        		
        		//input validation
        		inputHandle.userSearchValidation(timeOrLocInput);
        		
        		//time range
        		//ask using units of days what time range they would like to see cases
        		if(timeOrLocInput == 1) {
        			searchAndFilter.timeCasesDsiplay();
        		}
        		
        		//location
        		//ask what city the user wishes to see tick cases of
        		//this is case sensitive, meaning that validation will need to be done
        		//I'll take the city name, turn it all into lower case characters and then I'll only turn the first character upper case
        		
        		if(timeOrLocInput == 2) {
        			searchAndFilter.locationCasesDisplay();
        		}
        		
        	}
        	
        	else if(searchAndFilterInput == 2) {
        		//display all available tick sightings
        		String tickSightings = ""; 
        		
        		try {
					tickSightings = api.getAllSightings();
				} 
        		catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
        		
        		System.out.println(tickSightings);
        	}
        }
        
        //quitting software
        else if(input == 2) {
        	System.out.println("You have quit the software");
        	System.exit(0);
        }
	}
}
