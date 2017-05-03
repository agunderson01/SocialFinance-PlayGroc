import configs.TestAppConfig;
import configs.TestDataConfig;
import org.junit.Test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
import static org.junit.Assert.*;

import models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import services.impl.TaskServiceImpl;

@ContextConfiguration(classes = { TestAppConfig.class, TestDataConfig.class } )
public class TaskTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private TaskServiceImpl taskService;

    @Test
    public void testNullTask() {
        Task t1 = new Task();
        t1.setTitle("Ah");
        taskService.saveTask(t1);
        Task t2 = taskService.getTask(t1.getId());
        assertTrue("Loaded task is null", t2 != null);
    }

    @Test
    public void testTitleTask() {
        Task t1 = new Task();
        t1.setTitle("Ah");
        taskService.saveTask(t1);
        Task t2 = taskService.getTask(t1.getId());
        assertTrue("Saved title is not equal to savee title", t1.getTitle().equals(t2.getTitle()));
    }

}