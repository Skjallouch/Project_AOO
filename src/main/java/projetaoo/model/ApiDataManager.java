package projetaoo.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ApiDataManager {
    Logger log = LoggerFactory.getLogger(ApiDataManager.class);

    private final HttpClient client;
    private final String baseUrl;

    public ApiDataManager(String baseUrl) {
        this.client = HttpClient.newHttpClient();
        this.baseUrl = baseUrl;
    }

    public String getBaseCarboneData() throws IOException, InterruptedException {
        String endpoint = "/explore/v2.1/catalog/datasets/base-carbone/records?limit=20";
        return getData(endpoint);
    }

    private String getData(String endpoint) throws IOException, InterruptedException {
        /*
         * try {
         * HttpRequest request = HttpRequest.newBuilder()
         * .uri(URI.create(baseUrl + endpoint))
         * .GET()
         * .build();
         * HttpResponse<String> response = client.send(request,
         * HttpResponse.BodyHandlers.ofString());
         * return response.body();
         * } catch (Exception e) {
         * e.printStackTrace();
         * return "Erreur lors de la récupération des données: " + e.getMessage();
         * }
         */
        log.info("Appel de l'API à l'URL: {}", baseUrl + endpoint);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Réponse reçue de l'API: {}", response.body().substring(0, Math.min(response.body().length(), 500)));

        return response.body();
    }
}