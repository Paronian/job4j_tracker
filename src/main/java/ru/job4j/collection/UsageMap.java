package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("bagrat@mail.ru", "Юлов Бор Васильевич");
        map.put("yusupov@yandex.ru", "Юсупов Илья Васильевич");
        map.put("yusupov@yandex.ru", "Юсупов Илья Васильевич");
        map.put("bagrat@mail.ru", "Паронян Баграт Ашотович");
        map.put("yynn@mail.ru", "Паронян Баграт Ашотович");
        map.put("anna@yandex.ru", "Юлов Бор Васильевич");
        for (String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
