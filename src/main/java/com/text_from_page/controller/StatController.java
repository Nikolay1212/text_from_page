package com.text_from_page.controller;

import com.text_from_page.model.Word;
import com.text_from_page.service.WordService;
import com.text_from_page.util.Parser;
import com.text_from_page.util.ParserFromHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class StatController {

    @Autowired
    WordService wordService;

    @GetMapping("/url")
    public String getUrl(){
        return "getStat";
    }


    @PostMapping(value = "/stat")
    public String getStat(@RequestParam("url") String url, Model model) throws IOException {

        Parser parser = new ParserFromHtml();
        Map<String, Integer> wordStat = parser.parse(url);

        for(Map.Entry<String, Integer> word : wordStat.entrySet()) {
            wordService.save(getWord(word.getKey(), word.getValue()));
        }

        model.addAttribute("wordStat", wordStat);

        return "putStat";
    }

    private static Word getWord(String word, Integer score) {
        return Word.builder().
                word(word)
                .score(score)
                .build();
    }
}