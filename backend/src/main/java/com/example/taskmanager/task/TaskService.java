package com.example.taskmanager.task;

import com.example.taskmanager.NotFoundException;
import com.example.taskmanager.task.enums.TaskPriority;
import com.example.taskmanager.task.enums.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }


    public Task create(Task task){
        return repo.save(task);
    }

    public List<Task> getAllTasks(TaskStatus status, TaskPriority priority){
        if(status == null && priority == null){
            return repo.findAll();
        }
        if(status == null && priority != null){
            return repo.findByPriority(priority);
        }
        if(status != null && priority == null){
            return repo.findByStatus(status);
        }
        return repo.findByStatusAndPriority(status, priority);
    }

    public Task getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Task nicht gefunden: " + id));
    }

    public Task update(Task updatedTask){
        Long id = updatedTask.getId();
        Task currentTask = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Task nicht gefunden: " + id));

        if(updatedTask.getTitle() != null){
            currentTask.setTitle(updatedTask.getTitle());
        }
        if(updatedTask.getDescription() != null){
            currentTask.setDescription(updatedTask.getDescription());
        }
        if(updatedTask.getStatus() != null){
            currentTask.setStatus(updatedTask.getStatus());
        }
        if(updatedTask.getPriority() != null){
            currentTask.setPriority(updatedTask.getPriority());
        }
        return repo.save(currentTask);
    }

    public void delete(Long id) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Task nicht gefunden: " + id));
        repo.delete(task);
    }
}
