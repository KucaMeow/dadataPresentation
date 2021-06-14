package ru.itis.dadatarest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.itis.dadatarest.dto.SuggestionList;
import java.util.Collections;

@Service
public class DadataSerivce {

    @Value("${dadata.auth}")
    private String token;

    public SuggestionList suggestFIO(String query) {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> headerValues = new LinkedMultiValueMap<>();
        headerValues.put("Accept", Collections.singletonList("application/json"));
        headerValues.put("Content-Type", Collections.singletonList("application/json"));
        headerValues.put("Authorization", Collections.singletonList("Token " + token));
        HttpEntity<String> request = new HttpEntity<>(query, headerValues);

        return restTemplate
                .postForObject("https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/fio",
                request, SuggestionList.class);
    }
}
