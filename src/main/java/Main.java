import java.util.Scanner;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 * ClassSearch App.
 */
public class Main {

  /**
   * Execution starts here.
   *
   * @param args command-line arguments - not used here.
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("JHU - WSE - CS Dpt.");
    System.out.println("Spring 2021");
    System.out.println("Class Search");
    System.out.println("Enter your search query");
    String query = input.nextLine();

    search(query);
  }

  // Fetch Spring 2021 CS courses from SIS API
  // Display those which their title contains "query" string.
  // Pre: query != null && query.length() > 0
  private static void search(String query) {
    final String BASE_URL = "https://sis.jhu.edu/api/classes";
    // TODO you must store your API Key in environment variable JHU_API_KEY
    final String KEY = System.getenv("JHU_API_KEY");

    // TODO you must update this implementation!
    String endpoint = BASE_URL + "/codes/schools?Key=" + KEY;
    HttpResponse<JsonNode> jsonResponse = Unirest.get(endpoint).asJson();
    System.out.println(jsonResponse.getBody().toString());
  }
}
