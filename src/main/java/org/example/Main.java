package org.example;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Router router = new Router(new HashMap<>());
        router.addRoute("/", "HomeController");
        router.addRoute("/about", "AboutController");
        router.addRoute("/contact", "ContactController");

        System.out.println(router.callRoute("/"));
        System.out.println(router.callRoute("/about"));
        System.out.println(router.callRoute("/contact"));
    }
}