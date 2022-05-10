package com.first.taskapp.controllers;

import com.first.taskapp.dto.TasksResponse;
import com.first.taskapp.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;
    @GetMapping("")
    public TasksResponse getAllTasks(){
        var tasks = tasksService.getAllTasks();
        return new TasksResponse(tasks.size(), tasks);
    }

}
