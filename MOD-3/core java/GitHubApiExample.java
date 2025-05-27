import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GitHubApiExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // Create GET request to GitHub API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com/repos/openai/gpt-3"))
                .GET()
                .build();

        // Send request and get response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print status code
        System.out.println("Status code: " + response.statusCode());

        // Print response body
        System.out.println("Response body:");
        System.out.println(response.body());

        // Optional: parse JSON using Gson
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

        String repoName = jsonObject.get("name").getAsString();
        String description = jsonObject.get("description").getAsString();
        int stars = jsonObject.get("stargazers_count").getAsInt();

        System.out.println("\nParsed JSON data:");
        System.out.println("Repository Name: " + repoName);
        System.out.println("Description: " + description);
        System.out.println("Stars: " + stars);
    }
}
