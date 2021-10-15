package com.text_from_page.util;

import com.text_from_page.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParserFromHtml implements Parser {

    @Override
    public Map<String, Integer> parse(String source) throws IOException {

        Map<String, Integer> wordStat;

        try {
            Document doc = Jsoup.connect(source).get();
            String text = doc.body().text();
            String[] words = text.split("\\s*(\\s|,|!|:|\\?|\"|\\.|\\d+)\\s*");
            wordStat = new HashMap<>();
            for (String str :
                    words) {
                if (wordStat.containsKey(str)) {
                    int value = wordStat.get(str);
                    wordStat.put(str, ++value);
                } else if (str.length() > 0) {
                    wordStat.put(str, 1);
                }
            }

        } catch (IOException e) {
            Logger logger = new Logger();
            logger.log(e.toString());
            throw new IOException("Invalid source");
        }
        return wordStat;
    }
}
