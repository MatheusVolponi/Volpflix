package br.com.Volpflix.main;

import br.com.Volpflix.models.OmdbTitle;
import br.com.Volpflix.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!search.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            search = read.nextLine();

            if(search.equalsIgnoreCase("sair")) {
                break;
            }

            String encodedSearch = URLEncoder.encode(search, StandardCharsets.UTF_8);
            String address = "https://www.omdbapi.com/?t=" + encodedSearch + "&apikey=bd022199";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            OmdbTitle myTitleOMDB = gson.fromJson(json, OmdbTitle.class);

            try {
                Title myTitle = new Title(myTitleOMDB);
                System.out.println(myTitle);

                titles.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println("Erro encontrado:");
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titles);
        FileWriter writer = new FileWriter("filmes.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("Programa finalizou corretamente.");
    }
}
