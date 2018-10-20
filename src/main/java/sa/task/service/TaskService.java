package sa.task.service;

import sa.task.model.Task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TaskService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Task> getAllTasks(int first, int maxResult) {
        return entityManager.createNamedQuery(Task.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Task getTaskByCode(long code){
        return entityManager.find(Task.class, code);
    }

    public Task createTask(Task task) {
        entityManager.persist(task);
        entityManager.flush();
        return task;
    }

    public Task updateTask(long code, Task task) {
        Task taskToUpdate = entityManager.find(Task.class, code);
        taskToUpdate.setName(task.getName());
        taskToUpdate.setArchivado(task.getArchivado());
        taskToUpdate.setDescription(task.getDescription());
        //taskToUpdate.setPrueba(task.getPrueba());
        //taskToUpdate.setLista(task.getLista());
        entityManager.merge(taskToUpdate);
        return entityManager.find(Task.class, code);
    }

    public long deleteTask(long code) {
        Task task = entityManager.find(Task.class, code);
        entityManager.remove(task);
        return code;
    }
}
