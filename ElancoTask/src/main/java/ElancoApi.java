import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ElancoApi {

	//this class will focus on the get points for all the fields of the json tick
	//sightings
	private static final String BASE_URL = "https://dev-task.elancoapps.com/data";

	private final HttpClient client = HttpClient.newHttpClient();

	//getting all sightings
	public String getAllSightings() throws IOException, InterruptedException {

		//request for all of the sightings
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/tick-sightings")).GET().build();

		//store the sightings found
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		//create a JSON parser
		ObjectMapper mapper = new ObjectMapper();

		//read the API response as JSON
		JsonNode json = mapper.readTree(response.body());

		//format the JSON with indentation for readability
		String formattedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

		//return the formatted JSON
		return formattedJson;
	}

	//getting the tick sightings based on the city inputted
	public String getTickSightingsCity(String city) throws IOException, InterruptedException {
		String url = BASE_URL + "/tick-sightings/city/" + city;

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

	//getting the tick sightings based on the species of the animal
	public String getTickSightingsSpecies(String species) throws IOException, InterruptedException {
		String url = BASE_URL + "/tick-sightings/species/" + species;

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

	public String getTickSightingsDate(String dateFromUser) throws IOException, InterruptedException {

		ObjectMapper mapper = new ObjectMapper();

		//retrieve all sightings from the API
		JsonNode root = mapper.readTree(getAllSightings());

		//store matching cases
		StringBuilder results = new StringBuilder();

		//loop through all sightings
		for (JsonNode sighting : root) {

			//retrieve the date of the current sighting
			JsonNode dateElement = sighting.get("date");

			//check whether the date exists
			if (dateElement != null) {
				String apiDateOnly = dateElement.asText().substring(0, 10);
				
				if (apiDateOnly.equals(dateFromUser)) {
					//add the complete sighting to the results
					results.append(sighting.toPrettyString()).append("\n");
				}
			}
		}

		//return matching cases
		if (results.length() == 0) {
			return "No tick sightings found for " + dateFromUser;
		}

		return results.toString();
	}
}