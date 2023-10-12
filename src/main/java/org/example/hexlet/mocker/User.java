package org.example.hexlet.mocker;

import net.datafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {
    private static final int USERS_COUNT = 30;

    private static int idCounter = USERS_COUNT;

    public static List<Map<String, String>> getUsers() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<String> ids = IntStream
                .range(1, USERS_COUNT + 1)
                .mapToObj(i -> Integer.toString(i))
                .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Map<String, String>> users = new ArrayList<>();

        for (int i = 0; i < USERS_COUNT; i++) {
            Map<String, String> user = new HashMap<>();
            user.put("id", ids.get(i));
            user.put("firstName", faker.name().firstName());
            user.put("lastName", faker.name().lastName());
            users.add(user);
        }

        return users;
    }

    public static Map<String, String> getRandomUser() {
        Random random = new Random(123);
        var idx = random.nextInt(30);

        return getUsers().get(idx);
    }

    public static String getNextId() {
        int id = ++idCounter;
        return Integer.toString(id);
    }

}