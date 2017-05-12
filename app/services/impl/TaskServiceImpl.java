package services.impl;

import models.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.TaskService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Task> getTasks() {
        // TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);
        // List<Task> results = query.getResultList();
        List<Task> results = em.createQuery("SELECT t FROM Task t", Task.class)
                        .getResultList();
        logger.info("Found {} tasks.", results.size());
        return results;
    }

    @Override
    public Task getTask(long id) {
        Task t = em.find(Task.class, id);
        if (t !=null) {
            logger.info("Found task with id " + id + " and contents " + t.getTitle());
        }
        else {
            logger.info("No task found with id {}", id );
        }
        return t;
    }

    @Override
    public Task getTask(String id) {
        try {
            long id_l = Long.parseLong(id);
            Task t = getTask(id_l);
            return t;
        } catch (NumberFormatException ex) {
            return null;  // why  do in controller instead
        }
    }

    @Override
    public Task findTaskByTitle(String title) {
        List<Task> tasks = getTasks();
        for (Task t:tasks ) {
            if (t.getTitle().equals(title)) {
                return t;
            }
        }
        // When not found, return the a null as the Task
        return null;
    }

    @Override
    public void deleteAll() {
        int deletedCount = em.createQuery("DELETE FROM Task", Task.class).executeUpdate();
        logger.info("Deleted " + deletedCount + " tasks.");
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        em.merge(task);
        logger.info("Updated task with id " + task.getId());
    }

    @Override
    @Transactional
    public void deleteTask(Task task) {
        logger.info("Deleted task with id " + task.getId());
        em.remove(task);
    }

    @Override
    @Transactional
    public void deleteTask(String id) {
        try {
            long id_l = Long.parseLong(id);
            Task t = getTask(id_l);
            deleteTask(t);
        } catch (NumberFormatException ignored) { }
    }

    @Override
    public void deleteTask(long id) {
        Task t = getTask(id);
        deleteTask(t);
    }

    @Override
    @Transactional
    public Task saveTask(Task task) {
        em.persist(task);
        logger.info("Saved task with contents " + task.getTitle());
        return task;
    }
}
