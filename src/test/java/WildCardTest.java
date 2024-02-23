import org.example.WildCardRouter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildCardTest {
    @Test
    public void testCallRouteWithWildcardMatch() {
        // Arrange
        Map<String, String> handlers = new HashMap<>();
        handlers.put("/users/*/profile", "ProfileController");
        handlers.put("/users/*/settings", "SettingsController");

        WildCardRouter router = new WildCardRouter(handlers);

        // Act
        String result1 = router.callRoute("/users/123/profile");
        String result2 = router.callRoute("/users/456/settings");

        // Assert
        assertEquals("ProfileController", result1);
        assertEquals("SettingsController", result2);
    }

    @Test
    public void testCallRouteWithWildcardMatchTrailingSlash() {
        // Arrange
        Map<String, String> handlers = new HashMap<>();
        handlers.put("/users/*/profile", "ProfileController");
        handlers.put("/users/*/settings", "SettingsController");

        WildCardRouter router = new WildCardRouter(handlers);

        // Act
        String result1 = router.callRoute("/users/123/profile/");
        String result2 = router.callRoute("/users/456/settings/");

        // Assert
        assertEquals("ProfileController", result1);
        assertEquals("SettingsController", result2);
    }

}
