package com.text_from_page.service;

import com.text_from_page.model.Word;
import com.text_from_page.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void save(Word word) {
        wordRepository.save(word);
    }

    public String getBooks() {
        return "AAA";
    }
}
