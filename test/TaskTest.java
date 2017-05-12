import static org.junit.Assert.assertTrue;

import configs.TestAppConfig;
import configs.TestDataConfig;

import models.Task;

// import services.impl.TaskServiceImpl;
import services.TaskService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(classes = { TestAppConfig.class, TestDataConfig.class } )
public class TaskTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private TaskService taskService;

    @Test
    public void testNotNullTask() {
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
        assertTrue("Saved title is equal to changed title", t1.getTitle().equals(t2.getTitle()));
    }
}

