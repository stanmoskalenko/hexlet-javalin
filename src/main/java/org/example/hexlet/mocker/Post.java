package org.example.hexlet.mocker;

import net.datafaker.Faker;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

public class Post {
    private static final int POST_COUNT = 60;

    public static List<Map<String, String>> getPosts() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        String[] twitterKeywords = {"java", "clojure", "php"};

        List<String> ids = new ArrayList<>(IntStream
                .range(1, POST_COUNT + 1)
                .mapToObj(Integer::toString)
                .toList());
        Collections.shuffle(ids, random);

        List<Map<String, String>> posts = new ArrayList<>();

        for (int i = 0; i < POST_COUNT; i++) {
            Map<String, String> post = new HashMap<>();
            var user = User.getRandomUser();
            post.put("id", ids.get(i));
            post.put("user_id", user.get("firstName"));
            post.put("user", user.get("id"));
            post.put("username", faker.twitter().userName());
            post.put("description", faker.twitter().text(twitterKeywords, 5, 5));
            posts.add(post);
        }
        return posts;
    }
}
