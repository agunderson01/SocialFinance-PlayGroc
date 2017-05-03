import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.Application;
import models.Task;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import static org.junit.Assert.*;
import static play.test.Helpers.*;


public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertTrue(a == 2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("HELLO, WORLD", play.data.Form.form(models.Task.class), new ArrayList<Task>());
        assertTrue(contentType(html).equals("text/html"));
        assertTrue(contentAsString(html).contains("HELLO, WORLD"));
    }
}
