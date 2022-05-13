package com.first.taskapp.services;

import com.first.taskapp.models.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TasksServiceImpl implements TasksService{

    private List<Task> taskList;

    public TasksServiceImpl() {
        taskList = new ArrayList<>();
        taskList.add(new Task(1, "sample task", false, new Date()));
        taskList.add(new Task(2, "another task", false, new Date()));
        taskList.add(new Task(3, "more task", false, new Date()));


    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public Task getTaskById(int id) {
        return getTask(id);
    }

    private Task getTask(int id) {
        AtomicReference<Task> task = new AtomicReference<>();
        taskList.forEach(t -> {
            if(t.getId() == id){
                task.set(t);
            }
        });
        if(task.get() == null){
            throw new TaskNotFoundException(id);
        }
        return task.get();
    }

    @Override
    public Task createTask(Task task) {
        Task t = new Task(task.getId(), task.getName(), task.isCompleted(), task.getDueBy());
        taskList.add(t);
        return t;
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task t = getTask(id);
        if(task.getName() != null){
            t.setName(task.getName());
        }
        if(task.isCompleted()){
            t.setCompleted(task.isCompleted());
        }
        if(task.getDueBy() != null){
            t.setDueBy(task.getDueBy());
        }
        return t;
    }

    @Override
    public void deleteTask(int id) {
        taskList.remove(getTask(id));
    }
}
