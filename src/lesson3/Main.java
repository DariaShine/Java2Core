package lesson3;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        countOfWords();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов","+79213456783");
        phoneBook.add("Иванов","+79113456789");
        phoneBook.get("Иванов");
    };

    public static void countOfWords(){

        LinkedList<String> list = new LinkedList<>();
        list.add("молоко");
        list.add("хлеб");
        list.add("колбаса");
        list.add("сыр");
        list.add("масло");
        list.add("молоко");
        list.add("яйца");
        list.add("колбаса");
        list.add("сыр");
        list.add("сыр");

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Integer count = map.getOrDefault(list.get(i),0);
            map.put(list.get(i), count +1);
        }

        System.out.println(map);
        
    }
}
