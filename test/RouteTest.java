import org.junit.Test;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

public class RouteTest extends WithApplication {

    @Test
    public void testTaskGETRoute() {
        Result result = route(fakeRequest(GET, "/task"));
        assertTrue(result != null);
    }

}