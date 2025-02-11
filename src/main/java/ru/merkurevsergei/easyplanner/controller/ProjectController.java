package ru.merkurevsergei.easyplanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.merkurevsergei.easyplanner.model.ProjectEntity;
import ru.merkurevsergei.easyplanner.service.ProjectService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectEntity projectEntity) {
        ProjectEntity createdProjectEntity = projectService.createProject(projectEntity);
        return new ResponseEntity<>(createdProjectEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable UUID projectId) {
        Optional<ProjectEntity> project = projectService.getProjectById(projectId);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projectEntities = projectService.getAllProjects();
        return ResponseEntity.ok(projectEntities);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectEntity> updateProject(@PathVariable UUID projectId, @RequestBody ProjectEntity updatedProjectEntity) {
        ProjectEntity updated = projectService.updateProject(projectId, updatedProjectEntity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID projectId) {
        boolean isDeleted = projectService.deleteProject(projectId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}