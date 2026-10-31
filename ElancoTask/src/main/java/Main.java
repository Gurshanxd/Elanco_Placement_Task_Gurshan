import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		MenuUI ui = new MenuUI();
		InputHandler inputHandle = new InputHandler();
		UIEventHandler events = new UIEventHandler();
		
        
        //program start with menu
		ui.menuOptions();
		
		//get input for the first menu
		Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        
        
        //start validation
        inputHandle.menuValidation(input);
        
        //Events
        events.mainEvent(input);
        
        //end screen
        ui.programEnd();
	}
}
