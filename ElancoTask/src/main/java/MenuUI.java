
public class MenuUI {
	//this class holds elements of UI that will be shown in the command prompt
	public void menuOptions() {
		System.out.printf("""

				====================================================
				TICK SIGHTING MENU
				====================================================
				A Command-Line for tick sighting MVP
				----------------------------------------------------
				Please select a number from the following inputs to 
				select an action to perform: 
				[1] Search and filter tick sightings		
				[2] Exit

				""");
	}
	
	//search and filtering command line
	public void userSearch() {
		System.out.printf("""

				----------------------------------------------------
				SEARCH AND FILTER TICK SIGHTINGS
				----------------------------------------------------
				Please select a number from the following to choose 
				the action you wish to perform
				[1] Search and filter	[2] Display all available tick
										    sightings
				
				""");
	}
	
	public void searchAndFilterOption() {
		System.out.printf("""

				----------------------------------------------------
				SEARCH AND FILTER TICK SIGHTINGS
				----------------------------------------------------
				Would you like to filter the sightings by time range
				or location?
				
				[1] Time range				[2]Location
				
				""");
	}
	
	public void programEnd() {
		System.out.printf("""

				----------------------------------------------------
				End
				----------------------------------------------------
				Thank you for your time :D
				
				""");
	}
}
