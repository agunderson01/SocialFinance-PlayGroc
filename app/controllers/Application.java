package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Controller;
import play.mvc.Result;

import play.data.Form;

import services.TaskService;
import views.html.*;
import java.util.List;
import models.Task;

@org.springframework.stereotype.Controller
public class Application extends Controller {

    @Autowired
    private TaskService taskService;

    public Result index() {
        List<Task> tasks = taskService.getTasks();
        return ok(index.render("Task Manager", Form.form(Task.class), tasks));
    }
}
