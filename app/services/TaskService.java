package services;

import models.Task;

import java.util.List;

public interface TaskService {

    /**
     * Returns a list of tasks
     * @return a list of tasks
     */
    List<Task> getTasks();

    /**
     * Get a specific task
     * @param id of task to get
     * @return task with id
     */
    Task getTask(long id);

    /**
     * Get a specific task
     * @param id of task to get
     * @return task with id
     */
    Task getTask(String id);

    /**
     * Find if there is an existing task with this title
     * @param title of task to look for
     * @return The task that was found or null
     */
    Task findTaskByTitle(String title);

    /**
     * Delete all tasks
     */
    void deleteAll();

    /**
     * Update task
     * @param task to update
     */
    void updateTask(Task task);

    /**
     * Delete a specific task
     * @param task to delete
     */
    void deleteTask(Task task);

    /**
     * Delete a specific task
     * @param id of task to delete
     */
    void deleteTask(String id);

    /**
     * Delete a specific task
     * @param id of task to delete
     */
    void deleteTask(long id);

    /**
     * Save a task
     * @param task to save
     * @return task saved
     */
    Task saveTask(Task task);
}
