package com.first.taskapp.dto;

import com.first.taskapp.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class TasksResponse {
    private int tasksCount;
    private List<Task> tasks;
}
