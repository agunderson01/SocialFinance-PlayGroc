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

    public Result getTasks() {
        List<Task> t = taskService.getTasks();
        return ok(Json.toJson(t));
    }

    public Result getTask(String id) {
        Task t = taskService.getTask(id);
        return ok(Json.toJson(t));
    }

    public Result createTask() {
        Form<Task> form = Form.form(Task.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest();
        }

        Task task = form.get();
        task = taskService.saveTask(task);
        logger.info("New task returned with id " + task.getId());
        return ok(Json.toJson(task.getId()));
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
