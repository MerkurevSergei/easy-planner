package ru.merkurevsergei.easyplanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.merkurevsergei.easyplanner.dto.TaskDto;
import ru.merkurevsergei.easyplanner.model.TaskEntity;
import ru.merkurevsergei.easyplanner.service.TaskService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.findAll().stream().map(TaskDto::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable UUID id) {
        return taskService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable UUID id, @RequestBody TaskEntity taskDetails) {
        return taskService.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setPriority(taskDetails.getPriority());
                    task.setStartDate(taskDetails.getStartDate());
                    task.setDueDate(taskDetails.getDueDate());
                    task.setFeature(taskDetails.getFeature());
                    task.setParentTask(taskDetails.getParentTask());
                    task.setAssignee(taskDetails.getAssignee());
                    return ResponseEntity.ok(taskService.save(task));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
        return taskService.findById(id)
                .map(task -> {
                    taskService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}