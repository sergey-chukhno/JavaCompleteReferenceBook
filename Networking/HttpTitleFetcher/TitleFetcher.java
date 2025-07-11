import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.*;

public class TitleFetcher {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TitleFetcher <URL>");
            return;
        }

        String url = args[0];

        try {
            // Step 1: Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Step 2: Create HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Step 3: Send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Step 4: Extract <title> tag using regex
            String html = response.body();
            String title = extractTitle(html);

            if (title != null) {
                System.out.println("Title: " + title);
            } else {
                System.out.println("No <title> tag found.");
            }

        } catch (Exception e) {
            System.out.println("Error fetching title: " + e.getMessage());
        }
    }

    private static String extractTitle(String html) {
        // Case-insensitive regex for <title>...</title>
        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
}
