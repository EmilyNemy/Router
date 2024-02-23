package org.example;

import java.util.HashMap;

public class Router {
    private final HashMap<String, String> handlers;

    public Router(HashMap<String, String> handlers) {
        this.handlers = handlers;
    }

    public String callRoute(String path) {
        if(handlers.get(path) == null){
            throw new RuntimeException("This route does not exist yet");
        }
        return handlers.get(path);
    }

    public void addRoute(String name, String handler) {
        handlers.put(name, handler);
    }
}

// TODO if asked - to hard code the path/ routes
//private String callRoute(String path) {
//    switch (path) {
//
//        case "/foo":
//            return "foo";
//        case "/bar":
//            return "bar";
//        default:
//            throw new RuntimeException("No available Mapping");
//    }
//}
