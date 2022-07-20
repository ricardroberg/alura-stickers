import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes

        TreeMap<String, String> opcoes = new HashMap<>(
            {"1": "top250Movies"},
            {"2": "top250Movies"},
            {"3": "top250Movies"},
            {"4": "top250Movies"}
        )

        String top250Movies = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String top250Tv = "https://api.mocki.io/v2/549a5d8b/Top250TVs";
        String mostPopularMovie = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
        String mostPopularTv = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // System.out.println(body);

        // extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // extrair e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
