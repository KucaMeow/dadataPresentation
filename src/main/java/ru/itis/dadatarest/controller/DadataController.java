package ru.itis.dadatarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dadatarest.dto.SuggestionList;
import ru.itis.dadatarest.service.DadataSerivce;

@RestController
public class DadataController {

    @Autowired
    private DadataSerivce dadataSerivce;

    @PostMapping ("/suggest/fio")
    public ResponseEntity<SuggestionList> suggestFIO (@RequestBody String query) {
        return ResponseEntity.ok(dadataSerivce.suggestFIO(query));
    }
}
