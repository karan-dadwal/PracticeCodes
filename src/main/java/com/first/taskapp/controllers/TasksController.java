package com.first.taskapp.controllers;

import com.first.taskapp.dto.ErrorResponse;
import com.first.taskapp.dto.SuccessResponse;
import com.first.taskapp.dto.TasksResponse;
import com.first.taskapp.models.Task;
import com.first.taskapp.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;


    @GetMapping("/")
    public ResponseEntity<TasksResponse> getAllTasks(){
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(new TasksResponse(tasks.size(), tasks));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id){
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteTaskById(@PathVariable("id") Integer id){
        tasksService.deleteTask(id);
        return ResponseEntity.accepted().body(new SuccessResponse("deleted"+id));
    }
    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception ex){
        return new ResponseEntity<>(
                    new ErrorResponse(ex.getMessage()),
                HttpStatus.NOT_FOUND
                );
        }
    }


