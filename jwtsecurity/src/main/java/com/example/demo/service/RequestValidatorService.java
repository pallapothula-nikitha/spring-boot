package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class RequestValidatorService {

    public List<String> getResponses(List<String> validAuthTokens, List<List<String>> requests) {
        List<String> responses = new ArrayList<>();

        for (List<String> request : requests) {
            String method = request.get(0);
            String url = request.get(1);

            String query = "";
            if (url.contains("?")) {
                query = url.substring(url.indexOf("?") + 1);
            }

            Map<String, String> params = new LinkedHashMap<>();
            for (String part : query.split("&")) {
                if (!part.contains("=")) continue;
                String[] kv = part.split("=", 2);
                String key = URLDecoder.decode(kv[0], StandardCharsets.UTF_8);
                String value = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                params.put(key, value);
            }

            String token = params.get("token");
            if (token == null || !validAuthTokens.contains(token)) {
                responses.add("INVALID");
                continue;
            }

            if ("POST".equalsIgnoreCase(method)) {
                String csrf = params.get("csrf");
                if (csrf == null || !csrf.matches("^[a-z0-9]{8,}$")) {
                    responses.add("INVALID");
                    continue;
                }
            }

            // Build VALID response excluding "token" and "csrf"
            StringBuilder sb = new StringBuilder("VALID");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getKey().equals("token") || entry.getKey().equals("csrf")) continue;
                sb.append(", ").append(entry.getKey()).append(", ").append(entry.getValue());
            }
            responses.add(sb.toString());
        }

        return responses;
    }
}