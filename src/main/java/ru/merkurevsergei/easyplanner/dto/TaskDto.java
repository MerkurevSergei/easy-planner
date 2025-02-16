package ru.merkurevsergei.easyplanner.dto;

import lombok.Getter;
import ru.merkurevsergei.easyplanner.model.TaskEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TaskDto {

    public TaskDto(TaskEntity taskEntity) {
        this.id = taskEntity.getId();
        this.title = taskEntity.getTitle();
        this.description = taskEntity.getDescription();
        this.priority = taskEntity.getPriority();
        this.assignee = taskEntity.getAssignee().getLogin();
        this.startDate = taskEntity.getStartDate();
        this.dueDate = taskEntity.getDueDate();
        this.createdBy = taskEntity.getCreatedBy().getLogin();
        this.createdAt = taskEntity.getCreatedAt();
        this.updatedAt = taskEntity.getUpdatedAt();
    }

    private final UUID id;

    private final String title;

    private final String description;

    private final Integer priority;

    private final String assignee;

    private final LocalDate startDate;

    private final LocalDate dueDate;

    private final String createdBy;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;
}