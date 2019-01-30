package org.sadtech.vkbot.core.insert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertWords {

    private String inText;
    private String outText;

    public void insert(List<String> words) {
        Pattern pattern = Pattern.compile("\\{(\\d+)}"); // Задаем шаблон
        Matcher m = pattern.matcher(inText);             // Инициализация Matcher
        StringBuffer result = new StringBuffer();   // Буфер для конечного значения
        while (m.find()) {                          // Проверка на совпадение
            if (Integer.parseInt(m.group(1)) < words.size()) {
                m.appendReplacement(result, words.get(Integer.parseInt(m.group(1)))); // Подставляем значение из HashMap
            } else {
                m.appendReplacement(result, m.group(0));
            }
        }
        m.appendTail(result);        // Добавить остаток строки
        outText = result.toString();
    }

    public void setInText(String inText) {
        this.inText = inText;
    }

    public String getOutText() {
        return outText;
    }
}


