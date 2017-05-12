import static org.junit.Assert.assertFalse;
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

    @Test
    public void addEmptyTask() {
        Task t = new Task();
        assertFalse(taskService.saveTask(t)==null);
    }

    // ASG 5/12/2017 Test the service I added to assist with avoiding entry of duplicate shopping items
    @Test
    public void testFindTaskByTitle() {
        Task t1 = new Task();
        t1.setTitle("Ah");
        taskService.saveTask(t1);
        Task t2 = taskService.findTaskByTitle(t1.getTitle());
        assertTrue("We found the Task we saved by the title", t1.getTitle().equals(t2.getTitle()));
    }

    @Test
    public void testDeleteTask() {
        Task t1 = new Task();
        t1.setTitle("Ah");
        taskService.saveTask(t1);
        Task t2 = taskService.getTask(t1.getId());
        taskService.deleteTask(t2.getId());
        Task t3 = taskService.getTask(t2.getId());
        assertTrue("The deleted task should not be found", t3==null);
    }
}

