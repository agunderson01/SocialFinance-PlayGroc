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
