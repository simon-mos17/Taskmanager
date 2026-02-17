package com.example.taskmanager.task;

import com.example.taskmanager.task.enums.TaskPriority;
import com.example.taskmanager.task.enums.TaskStatus;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    //create
    @PostMapping
    public Task create(@Valid @RequestBody Task task){
        return service.create(task);
    }

    //getAllTasks
    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false)TaskStatus status, @RequestParam(required = false)TaskPriority priority){
        return service.getAllTasks(status, priority);
    }

    //readOne
    @GetMapping("/{id}")
    public Task readOneTask(@PathVariable Long id){
        return service.getById(id);
    }

    //updateTask
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return service.update(task);
    }

    //deleteTask
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.delete(id);
    }
}
