package org.example;

import java.util.Map;

public class WildCardRouter {
    private final Map<String, String> handlers;

    public WildCardRouter(Map<String, String> handlers) {
        this.handlers = handlers;
    }

    public String callRoute(String path) {
        for(Map.Entry<String, String> entry: handlers.entrySet()){
            String pattern = entry.getKey();
            if(isWildcardMatch(path, pattern)){
                return entry.getValue();
            }
        }
        return handlers.get(path);
    }

    private boolean isWildcardMatch(String path, String pattern){
        String[] pathSegments = path.split("/");
        String[] patternSegments = pattern.split("/");

        if(pathSegments.length != patternSegments.length){
            return false;
        }

        for(int i=0; i < pathSegments.length; i++){
            String pathSegment = pathSegments[i];
            String patternSegment = patternSegments[i];
            if(!pathSegment.equals(patternSegment) && !patternSegment.equals("*")){

                return false;
            }
        }
        return true;
    }
}
