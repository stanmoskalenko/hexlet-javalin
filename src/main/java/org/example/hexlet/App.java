package org.example.hexlet;

import io.javalin.Javalin;

public class App {
    public static Javalin getApp() {
        // Создаем приложение
        try (var app = Javalin.create(config -> config.plugins.enableDevLogging())) {
            app.get("/", ctx -> ctx.result("Hello World"));
            app.get("/users/{id}/post/{postId}", ctx ->
                    ctx.result("User ID: "
                            + ctx.pathParam("id")
                            + " Post ID: "
                            + ctx.pathParam("postId")));

            app.get("/hello", ctx -> {
                var name = ctx.queryParam("name");

                if (name == null) {
                    ctx.result("Hello World");
                } else {
                    ctx.result("Hello, " + name + "!");
                }
            });

            return app;
        }
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}