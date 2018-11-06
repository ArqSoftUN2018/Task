package sa.task.resource;

import sa.task.model.Task;
import sa.task.service.TaskService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.persistence.Entity;
import java.net.URI;
import java.util.List;

@Path("/tasks")
public class TaskResource {

    ResponseBuilder response;

    @Context
    UriInfo uriInfo;

    @EJB
    TaskService taskService;

    @GET
    public List<Task> getAllTasks(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return taskService.getAllTasks(first, maxResult);
    }

    @GET
    @Path("/group1/{group1}") //funcional
    public List<Task> getAllTaskslist(@PathParam("group1") int group1 ){
        return taskService.getAllTaskslist(group1);
    }


    @GET
    @Path("/userid/{userid}")//funcional
    public List<Task> getAllTasksuserid(@PathParam("userid") int userid){
        return taskService.getAllTasksuserid(userid);
    }

    @GET
    @Path("{code}")
    public Response getTaskByCode(@PathParam("code") long code) {
        Task task = taskService.getTaskByCode(code);
        response = Response.status(Response.Status.OK);
        response.entity(task);
        return response.build();
    }

    @POST
    public Response createTask(Task task) {
        Task createdTask = taskService.createTask(task);
        response = Response.status(Response.Status.CREATED);
        response.entity(createdTask);
        return response.build();
    }

    @PUT
    @Path("{code}")
    public Response updateTask(@PathParam("code") long code, Task task) {
        Task updatedTask = taskService.updateTask(code, task);
        response = Response.status(Response.Status.OK);
        response.entity(updatedTask);
        return response.build();
    }
    @PUT
    @Path("/archived/{code}")// funcional
    public Response updateArchived(@PathParam("code") long code, Task task) {
        Task updatedTask = taskService.updateArchived(code, task);
        response = Response.status(Response.Status.OK);
        response.entity(updatedTask);
        return response.build();
    }

    @PUT
    @Path("/board/{code}")// funcional
    public Response updateBoard(@PathParam("code") long code, Task task) {
        Task updatedTask = taskService.updateBoard(code, task);
        response = Response.status(Response.Status.OK);
        response.entity(updatedTask);
        return response.build();
    }
/*
    @PUT
    @Path("/group2/{code}")
    public Response updateTaskgroup(@PathParam("code") long code, Task task) {
        Task updatedTask = taskService.updateTaskgroup(code, task);
        response = Response.status(Response.Status.OK);
        response.entity(updatedTask);
        return response.build();
    }
*/

    @DELETE
    @Path("{code}")
    public Response deleteTask(@PathParam("code") long code) {
        long deletedTaskCode = taskService.deleteTask(code);
        response = Response.status(Response.Status.OK);
        response.entity(deletedTaskCode);
        return response.build();
    }

}
