package com.example.service;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class ContagemGeneroService {

    private final WebClient webClient;
    private final S3Client s3Client;

    public ContagemGeneroService(WebClient webClient, S3Client s3Client) {
        this.webClient = webClient;
        this.s3Client = s3Client;
    }

    public String processoDosDadosESalvamentoS3() {
        String apiUrl = "/RDSLambda";

        String resposta = webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Map<String, Integer> quantidadeGenero = processarParaJson(resposta);
        return saveToS3(quantidadeGenero);

    }

    private Map<String, Integer> processarParaJson(String resposta) {
        Map<String, Integer> quantidadeGenero = new HashMap<>();

        try {
            JSONArray jsonArray = new JSONArray(resposta);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String gender = jsonObject.getString("gender");
                quantidadeGenero.put(gender, quantidadeGenero.getOrDefault(gender, 0) + 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return quantidadeGenero;
    }

    private String saveToS3(Map<String, Integer> quantidadeGenero) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : quantidadeGenero.entrySet()) {
            sb.append("Gender: ").append(entry.getKey()).append(", Count: ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb.toString());
        byte[] dados = sb.toString().getBytes(StandardCharsets.UTF_8);

        String chave = "gender_count.txt";
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket("interview-digiage")
                .key(chave)
                .build();
        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(dados));

        System.out.println("Arquivo salvo em S3: " + chave);
        return "Arquivo salvo em S3: " + chave + " Valores: " + sb.toString();

    }
}
