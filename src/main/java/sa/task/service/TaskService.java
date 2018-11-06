package sa.task.service;

import sa.task.model.Task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.*;

@Stateless
public class TaskService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Task> getAllTasks(int first, int maxResult) {
        return entityManager.createNamedQuery(Task.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public List<Task> getAllTaskslist(int group1){
        return entityManager.createNamedQuery("TaskfindBygroup1").setParameter("group1", group1).getResultList();

    }

    public List<Task> getAllTasksuserid(int userid){
        return entityManager.createNamedQuery("TaskfindByuserid").setParameter("userid", userid).getResultList();

    }

    public Task getTaskByCode(long code){
        return entityManager.find(Task.class, code);
    }

    public Task createTask(Task task) {
        entityManager.persist(task);
        entityManager.flush();
        return task;
    }


    public Task updateArchived (long code, Task task) {
        Task taskToUpdate = entityManager.find(Task.class, code);
        taskToUpdate.setArchived(task.getArchived());
        entityManager.merge(taskToUpdate);
        return entityManager.find(Task.class, code);
    }
    public Task updateBoard (long code, Task task) {
        Task taskToUpdate = entityManager.find(Task.class, code);
        taskToUpdate.setBoard(task.getBoard());
        entityManager.merge(taskToUpdate);
        return entityManager.find(Task.class, code);
    }

    public Task updateTaskgroup(long code, Task task) {
      Task taskToUpdate = entityManager.find(Task.class, code);

      ArrayList<Integer> auxi= task.getGroup2();
      auxi.add(666);
      taskToUpdate.setGroup2(auxi);
      entityManager.merge(taskToUpdate);
      return entityManager.find(Task.class, code);
    }
    
    public Task updateTask(long code, Task task) {
        Task taskToUpdate = entityManager.find(Task.class, code);
        taskToUpdate.setName(task.getName());
        taskToUpdate.setArchived(task.getArchived());
        taskToUpdate.setComplete(task.getComplete());
        taskToUpdate.setGroup1(task.getGroup1());
        taskToUpdate.setUserid(task.getUserid());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setCreated(task.getCreated());
        taskToUpdate.setUpdated(task.getUpdated());
        //taskToUpdate.setGroup2(task.getGroup2());
        taskToUpdate.setDead(task.getDead());

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
