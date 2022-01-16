package lesson3;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> map = new HashMap<>();

    public void get(String surname) {
        System.out.println(surname + String.valueOf(map.get(surname)));
    }

    public void add(String surname, String phone){
        Set<String> set = map.getOrDefault(surname, new HashSet<>());
        set.add(phone);
        map.put(surname, set);
        System.out.println(map);
    }
}




