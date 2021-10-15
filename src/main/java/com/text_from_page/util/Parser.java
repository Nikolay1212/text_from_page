package com.text_from_page.util;

import java.io.IOException;
import java.util.Map;

public interface Parser {

    Map<String, Integer> parse(String source) throws IOException;

}
