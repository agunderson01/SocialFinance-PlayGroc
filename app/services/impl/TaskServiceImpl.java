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

    public Task getTask(long id) {
        Task t = em.find(Task.class, id);
        logger.info("Found task with id " + id + " and contents " + t.getTitle());
        return t;
    }

    public Task getTask(String id) {
        try {
            long id_l = Long.parseLong(id);
            Task t = getTask(id_l);
            return t;
        } catch (NumberFormatException ex) {
            return null;  // why  do in controller instead
        }
    }

    public void deleteAll() {
        int deletedCount = em.createQuery("DELETE FROM Task", Task.class).executeUpdate();
        logger.info("Deleted " + deletedCount + " tasks.");
    }

    @Transactional
    public void updateTask(Task task) {
        em.merge(task);
        logger.info("Updated task with id " + task.getId());
    }

    @Transactional
    public void deleteTask(Task task) {
        logger.info("Deleted task with id " + task.getId());
        em.remove(task);
    }

    @Transactional
    public void deleteTask(String id) {
        try {
            long id_l = Long.parseLong(id);
            Task t = getTask(id_l);
            deleteTask(t);
        } catch (NumberFormatException ignored) { }
    }

    public void deleteTask(long id) {
        Task t = getTask(id);
        deleteTask(t);
    }

    @Transactional
    public Task saveTask(Task task) {
        em.persist(task);
        logger.info("Saved task with contents " + task.getTitle());
        return task;
    }
}
