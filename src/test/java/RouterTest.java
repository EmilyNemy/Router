import org.example.Router;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RouterTest {
    @Test
    public void testCallRoute(){
        HashMap<String, String> handlers = new HashMap<>();
        handlers.put("/", "IndexController");
        handlers.put("/about", "AboutController");

        Router router = new Router(handlers);
        String result = router.callRoute("/about");

        Assertions.assertEquals("AboutController", result);
    }

    @Test
    public void testCallRouteWhichDoesNotExist(){
        HashMap<String, String> handlers = new HashMap<>();
        handlers.put("/", "IndexController");
        handlers.put("/about", "AboutController");

        Router router = new Router(handlers);

        Assertions.assertThrows(RuntimeException.class, () ->  router.callRoute("/someRoute"));

//        Assertions.assertEquals("This route does not exist yet", exception);
    }

    @Test
    public void testAddRoute(){
        Router router = new Router(new HashMap<>());
        router.addRoute("/contact", "ContactController");
        Assertions.assertEquals("ContactController", router.callRoute("/contact"));
    }


}
