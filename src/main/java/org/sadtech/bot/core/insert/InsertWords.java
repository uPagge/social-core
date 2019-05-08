package org.sadtech.bot.core.insert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertWords {

    private InsertWords() {
        throw new IllegalStateException();
    }

    public static String insert(String text, List<String> words) {
        Pattern pattern = Pattern.compile("\\{(\\d+)}");
        Matcher m = pattern.matcher(text);
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            if (Integer.parseInt(m.group(1)) < words.size()) {
                m.appendReplacement(result, words.get(Integer.parseInt(m.group(1))));
            } else {
                m.appendReplacement(result, m.group(0));
            }
        }
        m.appendTail(result);
        return result.toString();
    }
}


