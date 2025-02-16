package ru.merkurevsergei.easyplanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.merkurevsergei.easyplanner.model.TaskEntity;
import ru.merkurevsergei.easyplanner.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> findById(UUID id) {
        return taskRepository.findById(id);
    }

    public void deleteById(UUID id) {
        taskRepository.deleteById(id);
    }
}