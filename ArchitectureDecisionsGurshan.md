Architectural decisions:

* I have decided to implement multiple classes to make the program easier to read overall, as each section is responsible for an activity in the program. E.g. the InputHandler class holding methods to use when wanting to validate some inputs on certain circumstances
* ElancoApi - this class stores methods I can use in the program to perform mainly actions centered around retrieving tick cases based on a certain condition or parameter, and sending requests to retrieve the json data
* InputHandler - this class is self explanatory through the name, I made this to hold re-usable methods to validate inputs, for example menu options from the user as inputs are mainly done utilising integer based options, e.g. input "1" to do something
* MenuUI - this class holds different ASCII outputs to show for the menu. For example, the start menu has a ASCII based design to add uniqueness, but including these outputs in the other class files would bloat lines and make it harder to read. Hence, keeping it here would make it more readable and understandable for the rest of the program
* UIEventHandler - this class is where the menu's activities occur, meaning the main run of the software occurs here. So, if the user from Main decides to input an integer to actually perform an action from the menu, the mainEvent() would trigger, and lead to a sequence of events to occur. I could have left this in Main but I believe that making Main classes bloated is bad practice
* UserSearchAndFilter - this class holds the 2 methods to search and filter by location \& date. They are separate so that if the user wishes to search by a specific location or date they can do so
* Main - this is where all of the classes combine together in a single file to work. I made this class to be as easily readable as possible to help keep track of the activities occurring.
* Testing was done by downloading the json file in the Elanco API page. Which I did by executing the "tick-sightings" method shown and downloaded all of the cases. Then on notepad I would do ctrl + f to search for test cases in my program

