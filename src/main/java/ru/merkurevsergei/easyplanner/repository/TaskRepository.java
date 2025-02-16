package ru.merkurevsergei.easyplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.merkurevsergei.easyplanner.model.TaskEntity;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}