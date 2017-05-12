package controllers;

import models.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.TaskService;

import java.util.List;

@org.springframework.stereotype.Controller
public class TaskManager extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);

    @Autowired
    private TaskService taskService;

    public TaskService getTaskService() {
        return taskService;
    }

    public Result getTasks() {
        List<Task> t = taskService.getTasks();
        return ok(Json.toJson(t));
    }

    public Result getTask(String id) {
        Task t = taskService.getTask(id);
        return ok(Json.toJson(t));
    }

    public boolean checkTaskExistsP (Task potentialNewTask) {
        List<Task> tasks = taskService.getTasks();
        for (Task t:tasks ) {
            if (t.getTitle().equals(potentialNewTask.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public Result findTaskByTitle(String title) {
        Task t = taskService.findTaskByTitle(title);
        if ( t != null ) {
            return ok(Json.toJson(t));
        }
        else {
            return badRequest("No shopping item with title " + title + " found");
        }

    }

    public Result createTask() {
        Form<Task> form = Form.form(Task.class).bindFromRequest();
        if (form.hasErrors()) {
            // List<Task> tasks = getTaskService().getTasks();
            // return badRequest();
            // return badRequest(index.render("Your Groc List", form, tasks));
            logger.info("Error creating a task-probably nothing entered");
            return badRequest("Nothing entered");
        }

        Task task = form.get();

        // Get any cruft off the data
        task.setTitle(task.getTitle().trim());

        if ( checkTaskExistsP(task) ) {
            logger.info("No need to enter duplicate item {} on shopping list", task.getTitle());
            return badRequest("No need to save duplicate shopping item " + task.getTitle());
        }
        else {
            task = taskService.saveTask(task);
            logger.info("New task returned with id {}", task.getId());
            return ok(Json.toJson(task.getId()));
        }
    }

    public Result editTask(String id) {
        Form<Task> form = Form.form(Task.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest();
        }

        Task task = form.get();
        Task t = taskService.getTask(id);
        t.setTitle(task.getTitle());
        taskService.updateTask(t);
        return ok();
    }

    public Result removeTasks() {
        List<Task> t = taskService.getTasks();
        return ok();
    }

    public Result removeTask(String id) {
        taskService.deleteTask(id);
        return ok();
    }
}
